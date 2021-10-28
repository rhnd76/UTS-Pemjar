package com.example.aplikasi_photographi

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.frag_addon.*
import kotlinx.android.synthetic.main.frag_edukasi.*
import mi.polinema.uts_pemjar.MainActivity
import mi.polinema.uts_pemjar.R

class fragmentAddOn : Fragment(),View.OnClickListener {
    lateinit var thisParent : MainActivity
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?

    ): View? {
        thisParent = activity as MainActivity
        return inflater.inflate(R.layout.frag_addon,container,false)
    }
    override fun onClick(v: View?) {
        var popMenu = PopupMenu(thisParent, v)
        popMenu.menuInflater.inflate(R.menu.addon, popMenu.menu)
        popMenu.setOnMenuItemClickListener { item ->
            when(item.itemId) {
                R.id.apk1_1 -> {
                    var url = "https://play.google.com/store/apps/details?id=com.adobe.psmobile"
                    var intentKonten = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                    startActivity(intentKonten)
                }
                R.id.apk1_2 -> {
                    var url = "https://play.google.com/store/apps/details?id=com.adobe.lrmobile"
                    var intentKonten = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                    startActivity(intentKonten)
                }
                R.id.apk1_3 -> {
                    var url = "https://play.google.com/store/apps/details?id=com.niksoftware.snapseed"
                    var intentKonten = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                    startActivity(intentKonten)
                }
                R.id.apk1_4 -> {
                    var url = "https://play.google.com/store/apps/details?id=com.vsco.cam"
                    var intentKonten = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                    startActivity(intentKonten)
                }
                R.id.apk2_1 -> {
                    var url = "https://play.google.com/store/apps/details?id=com.nexstreaming.app.kinemasterfree"
                    var intentKonten = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                    startActivity(intentKonten)
                }
                R.id.apk2_2 -> {
                    var url = "https://play.google.com/store/apps/details?id=com.cyberlink.powerdirector.DRA140225_01"
                    var intentKonten = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                    startActivity(intentKonten)
                }
                R.id.apk2_3 -> {
                    var url = "https://play.google.com/store/apps/details?id=com.frontrow.vlog"
                    var intentKonten = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                    startActivity(intentKonten)
                }
            }
            false
        }
        popMenu.show()
//        var popMenu = PopupMenu(thisParent, v)
//        popMenu.menuInflater.inflate(R.menu.add1, popMenu.menu)
//        popMenu.setOnMenuItemClickListener { item ->
//            when(item.itemId) {
//                R.id.apk1_add1 -> {
//                    var url = "https://play.google.com/store/apps/details?id=com.adobe.psmobile"
//                    var intentKonten = Intent(Intent.ACTION_VIEW, Uri.parse(url))
//                    startActivity(intentKonten)
//                }
//                R.id.apk2_add1 -> {
//                    var url = "https://play.google.com/store/apps/details?id=com.adobe.lrmobile"
//                    var intentKonten = Intent(Intent.ACTION_VIEW, Uri.parse(url))
//                    startActivity(intentKonten)
//                }
//                R.id.apk3_add1 -> {
//                    var url = "https://play.google.com/store/apps/details?id=com.niksoftware.snapseed"
//                    var intentKonten = Intent(Intent.ACTION_VIEW, Uri.parse(url))
//                    startActivity(intentKonten)
//                }
//                R.id.apk4_add1 -> {
//                    var url = "https://play.google.com/store/apps/details?id=com.vsco.cam"
//                    var intentKonten = Intent(Intent.ACTION_VIEW, Uri.parse(url))
//                    startActivity(intentKonten)
//                }
//
//            }
//            true
//        }
//        popMenu.show()
//
//        var popMenu2 = PopupMenu(thisParent, v)
//        popMenu2.menuInflater.inflate(R.menu.add2, popMenu2.menu)
//        popMenu2.setOnMenuItemClickListener { item ->
//            when(item.itemId) {
//                R.id.apk1_add2 -> {
//                    var url = "https://play.google.com/store/apps/details?id=com.adobe.psmobile"
//                    var intentKonten = Intent(Intent.ACTION_VIEW, Uri.parse(url))
//                    startActivity(intentKonten)
//                }
//                R.id.apk2_add2 -> {
//                    var url = "https://play.google.com/store/apps/details?id=com.adobe.lrmobile"
//                    var intentKonten = Intent(Intent.ACTION_VIEW, Uri.parse(url))
//                    startActivity(intentKonten)
//                }
//                R.id.apk3_add2 -> {
//                    var url = "https://play.google.com/store/apps/details?id=com.niksoftware.snapseed"
//                    var intentKonten = Intent(Intent.ACTION_VIEW, Uri.parse(url))
//                    startActivity(intentKonten)
//                }
//            }
//            true
//        }
//        popMenu2.show()

    }
    override fun onViewCreated(v: View, savedInstanceState: Bundle?) {
        super.onViewCreated(v, savedInstanceState)
        btn_add1.setOnClickListener(this)
//        btn_add2.setOnClickListener(this)
//        btn_add1.setOnClickListener {
//            var popMenu = PopupMenu(activity, v)
//            popMenu.menuInflater.inflate(R.menu.addon, popMenu.menu)
//            popMenu.setOnMenuItemClickListener { item ->
//                when(item.itemId) {
//                    R.id.apk1_add1 -> {
//                        var url = "http://ipsmfestival.com/2019/10/05/mengenal-triangle-exposure-dalam-fotografi/"
//                        var intentKonten = Intent(Intent.ACTION_VIEW, Uri.parse(url))
//                        startActivity(intentKonten)
//                    }
//                    R.id.apk2_add1 -> {
//                        var url = "http://ipsmfestival.com/2019/10/05/mengenal-triangle-exposure-dalam-fotografi/"
//                        var intentKonten = Intent(Intent.ACTION_VIEW, Uri.parse(url))
//                        startActivity(intentKonten)
//                    }
//                }
//                false
//            }
//            popMenu.show()
//        }
//
//        btn_add2.setOnClickListener {
//            var popMenu2 = PopupMenu(activity, v)
//            popMenu2.menuInflater.inflate(R.menu.add2, popMenu2.menu)
//            popMenu2.setOnMenuItemClickListener { item ->
//                when(item.itemId) {
//                    R.id.apk1_add2 -> {
//                        var url = "http://ipsmfestival.com/2019/10/05/mengenal-triangle-exposure-dalam-fotografi/"
//                        var intentKonten = Intent(Intent.ACTION_VIEW, Uri.parse(url))
//                        startActivity(intentKonten)
//                    }
//                    R.id.apk2_add2 -> {
//                        var url = "http://ipsmfestival.com/2019/10/05/mengenal-triangle-exposure-dalam-fotografi/"
//                        var intentKonten = Intent(Intent.ACTION_VIEW, Uri.parse(url))
//                        startActivity(intentKonten)
//                    }
//                }
//                false
//            }
//            popMenu2.show()
//        }

    }
}