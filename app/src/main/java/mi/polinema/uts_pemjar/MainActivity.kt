package mi.polinema.uts_pemjar


import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import com.example.aplikasi_photographi.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.frag_addon.*
import kotlinx.android.synthetic.main.frag_edukasi.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    lateinit var fragGalery: fragmentGalery
    lateinit var fragEdukasi: fragmentEdukasi
    lateinit var fragUpload: fragmentUpload
    lateinit var fragAddOn: fragmentAddOn
    lateinit var fragProfil: fragmentProfil

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        btn_nav.setOnNavigationItemSelectedListener(this)
        fragGalery = fragmentGalery()
        fragEdukasi = fragmentEdukasi()
        fragUpload = fragmentUpload()
        fragAddOn = fragmentAddOn()
        fragProfil = fragmentProfil()

        val cal : Calendar = Calendar.getInstance()
        jam.text = "Jam "+SimpleDateFormat("HH:mm").format(cal.time)
    }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        when (p0.itemId) {
            R.id.nav_galery -> {
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.frame_0, fragGalery)
                    commit()
                }
            }
            R.id.nav_edukasi -> {
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.frame_0, fragEdukasi)
                    commit()
                }
            }
            R.id.nav_upload -> {
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.frame_0, fragUpload)
                    commit()
                }
            }
            R.id.nav_add_on -> {
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.frame_0, fragAddOn)
                    commit()
                }
            }
            R.id.nav_profil -> {
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.frame_0, fragProfil)
                    commit()
                }
            }
        }
        return true
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        var menuInflaterr = menuInflater
        menuInflaterr.inflate(R.menu.option, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item?.itemId) {
            R.id.option_2 -> {
                startActivity(Intent(this, LoginActivity::class.java))
                Toast.makeText(this, "Berhasil Log Out", Toast.LENGTH_SHORT).show()
            }
        }
        return  super.onOptionsItemSelected(item)
    }

}