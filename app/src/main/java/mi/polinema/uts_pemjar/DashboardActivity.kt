package mi.polinema.uts_pemjar

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseFirestore
    lateinit var builder:AlertDialog.Builder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        auth = FirebaseAuth.getInstance()
        db = Firebase.firestore

        builder = AlertDialog.Builder(this)

        btnProfil.setOnClickListener(this)
        btnDisplayUser.setOnClickListener(this)
        btnLogOut.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.btnProfil -> {
                val currentUser = auth.currentUser
                if (currentUser != null) {
                    val builder = AlertDialog.Builder(this)
                    builder.setTitle("User Profile").setMessage(
                        "Nama : ${currentUser!!.displayName}\n" +
                                "Email : ${currentUser!!.email}"
                    ).setNeutralButton("OK",null)
                    builder.show()
                }
            }
            R.id.btnDisplayUser ->{
                var paket: Bundle? = intent.extras
                var username=(paket?.getString("username"))
                var email=(paket?.getString("email"))
                var alamat=(paket?.getString("alamat"))
                var no_telp=(paket?.getString("no_telp"))
//                Intent(this, DisplayUserActivity::class.java).also {
//                    it.putExtra("email", email)
//                    it.putExtra("username", username)
//                    it.putExtra("alamat", alamat)
//                    it.putExtra("no_telp", no_telp)
//                    startActivity(it)
//                }
            }
            R.id.btnLogOut ->{
                builder.setTitle("Konfirmasi").setMessage("Yakin Ingin Log Out?")
                    .setIcon(android.R.drawable.ic_dialog_info)
                    .setPositiveButton("YA", signOut)
                    .setNegativeButton("Tidak", null)
                builder.show()
            }
        }
    }

    val signOut= DialogInterface.OnClickListener{ dialog, which ->
        auth.signOut()
        Intent(this, LoginActivity::class.java).also {
            it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(it)
        }
    }
}