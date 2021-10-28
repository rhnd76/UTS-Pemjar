package com.example.aplikasi_photographi

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.frag_galery.*
import mi.polinema.uts_pemjar.MainActivity
import mi.polinema.uts_pemjar.R
import mi.polinema.uts_pemjar.ShowDataUploadActivity

class fragmentGalery : Fragment() {
    lateinit var thisParent : MainActivity
    lateinit var save : Button
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        thisParent = activity as MainActivity
        return inflater.inflate(R.layout.frag_galery,container,false)

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        save = view.findViewById(R.id.lihat)

        lihat.setOnClickListener(){
            var intentGal = Intent(getActivity(), ShowDataUploadActivity::class.java)
            getActivity()?.startActivity(intentGal)
        }
    }
}