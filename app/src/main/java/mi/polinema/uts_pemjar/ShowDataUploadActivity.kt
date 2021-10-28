package mi.polinema.uts_pemjar

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import kotlinx.android.synthetic.main.show_data_upload.*

class ShowDataUploadActivity : AppCompatActivity(){
    lateinit var storage : StorageReference
    lateinit var db : CollectionReference
    lateinit var alFile : ArrayList<HashMap<String, Any>>
    lateinit var adapter : CustomAdapter
    lateinit var uri : Uri
    val F_NAME = "file_name"
    val F_TYPE = "file_type"
    val F_URL = "file_url"
    val F_NAMA = "nama"
    val F_CAPTION = "caption"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.show_data_upload)

        alFile = ArrayList()
        uri = Uri.EMPTY
    }
    override fun onStart() {
        super.onStart()
        storage = FirebaseStorage.getInstance().reference
        db = FirebaseFirestore.getInstance().collection("foto")
        db.addSnapshotListener{ querySnapshot, firebaseFirestoreException ->
            if(firebaseFirestoreException!=null){
                Log.e("firestore :", firebaseFirestoreException.message.toString())
            }
            showData()
        }
    }
    fun showData(){
        db.get().addOnSuccessListener { result ->
            alFile.clear()
            for(doc in result){
                val hm = HashMap<String, Any>()
                hm.put(F_NAME, doc.get(F_NAME).toString())
                hm.put(F_TYPE, doc.get(F_TYPE).toString())
                hm.put(F_NAMA, doc.get(F_NAMA).toString())
                hm.put(F_CAPTION, doc.get(F_CAPTION).toString())
                hm.put(F_URL, doc.get(F_URL).toString())
                alFile.add(hm)
            }
            adapter = CustomAdapter(this, alFile)
            lsV.adapter = adapter
        }
    }
}