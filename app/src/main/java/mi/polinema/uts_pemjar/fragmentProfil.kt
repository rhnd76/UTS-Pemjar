package com.example.aplikasi_photographi

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.frag_galery.*
import kotlinx.android.synthetic.main.frag_profil.*
import mi.polinema.uts_pemjar.MainActivity
import mi.polinema.uts_pemjar.R
import java.util.*

class fragmentProfil : Fragment(),View.OnClickListener {
    lateinit var thisParent: MainActivity
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?

    ): View? {
        thisParent = activity as MainActivity
        return inflater.inflate(R.layout.frag_profil, container, false)

    }

    override fun onClick(v: View?) {

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        profile.setOnClickListener() {

        }
//        save.setOnClickListener {
//            val var2 = adapterSpin.getItem(sp1.selectedItemPosition)
//        }

    }
}