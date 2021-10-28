package com.example.aplikasi_photographi

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.frag_edukasi.*
import kotlinx.android.synthetic.main.frag_upload.*
import mi.polinema.uts_pemjar.MainActivity
import mi.polinema.uts_pemjar.R

class fragmentEdukasi : Fragment(), View.OnClickListener {
    lateinit var thisParent: MainActivity
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?


    ): View? {
        thisParent = activity as MainActivity
        return inflater.inflate(R.layout.frag_edukasi, container, false)
    }

    override fun onClick(v: View?) {
            when(v?.id) {
                R.id.btn_edu1 -> {
                    var url = "http://ipsmfestival.com/2019/10/05/mengenal-triangle-exposure-dalam-fotografi/"
                    var intentKonten = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                    startActivity(intentKonten)
                }
                R.id.btn_edu2 -> {
                    var url = "http://digitalfotografi.net/mengenal-angle-dalam-fotografi/"
                    var intentKonten = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                    startActivity(intentKonten)
                }
                R.id.btn_edu3 -> {
                    var url = "https://ilmupedia.co.id/articles/cara-edit-foto/full"
                    var intentKonten = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                    startActivity(intentKonten)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_edu1.setOnClickListener(this)
        btn_edu2.setOnClickListener(this)
        btn_edu3.setOnClickListener(this)

        vidio.setOnClickListener() {

        }

        }
    }



