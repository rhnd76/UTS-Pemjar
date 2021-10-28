package mi.polinema.uts_pemjar

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.Continuation
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.UploadTask
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.upload_foto_galery.*
import java.io.File
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class UploadActivity : AppCompatActivity() , View.OnClickListener {
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.imgMhs ->{
                fileType = ".jpg"
                val intent = Intent()
                intent.setType("image/*")
                intent.setAction(Intent.ACTION_GET_CONTENT)
                startActivityForResult(intent,mediaHelper.getRcGallery())
            }
            R.id.btnKirim4 ->{
                if(uri !=null){
                    fileName = SimpleDateFormat("yyyMMddHHmmssSSS").format(Date())
                    val fileRef = storage.child(fileName+fileType)
                    fileRef.putFile(uri)
                        .continueWithTask(Continuation<UploadTask.TaskSnapshot, Task<Uri>> { task ->
                            return@Continuation fileRef.downloadUrl
                        })
                        .addOnCompleteListener { task ->
                            val hm = HashMap<String, Any>()
                            hm.put(F_NAMA, innama.text.toString())
                            hm.put(F_CAPTION, incaption.text.toString())
                            hm.put(F_NAME, fileName)
                            hm.put(F_TYPE, fileType)
                            hm.put(F_URL, task.result.toString())
                            db.document(fileName).set(hm).addOnSuccessListener {
                                Toast.makeText(
                                    this,
                                    "File successfully uploaded",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                }
            }
        }
    }
    lateinit var storage : StorageReference
    lateinit var db : CollectionReference
    lateinit var mediaHelper : MediaHelper
    var imStr = ""
    val RC_OK = 100
    lateinit var uri : Uri
    var fileType = ""
    var fileName = ""
    val F_NAME = "file_name"
    val F_TYPE = "file_type"
    val F_URL = "file_url"
    val F_NAMA = "nama"
    val F_CAPTION = "caption"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.upload_foto_galery)
        mediaHelper = MediaHelper(this)
        imgMhs.setOnClickListener(this)
        btnKirim4.setOnClickListener(this)
    }
    override fun onStart() {
        super.onStart()
        storage = FirebaseStorage.getInstance().reference
        db = FirebaseFirestore.getInstance().collection("foto")
        db.addSnapshotListener{ querySnapshot, firebaseFirestoreException ->
            if(firebaseFirestoreException!=null){
                Log.e("firestore :", firebaseFirestoreException.message.toString())
            }
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if((resultCode == Activity.RESULT_OK)&&(requestCode == RC_OK)){
            if(requestCode == mediaHelper.getRcGallery()){
                imStr = mediaHelper.getBitmapToString(data!!.data!!, imgMhs)
                if (data !=null){
                    uri = data.data!!
                }
            }
        }
    }
}