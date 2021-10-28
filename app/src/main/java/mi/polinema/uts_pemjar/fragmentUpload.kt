package com.example.aplikasi_photographi

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.frag_profil.*
import kotlinx.android.synthetic.main.frag_upload.*
import mi.polinema.uts_pemjar.MainActivity
import mi.polinema.uts_pemjar.R
import mi.polinema.uts_pemjar.ShowDataUploadActivity
import mi.polinema.uts_pemjar.UploadActivity

class fragmentUpload : Fragment(){
    lateinit var thisParent: MainActivity
    lateinit var save : Button
//    lateinit var imageView: ImageView
//    lateinit var button: Button

//    companion object {
//        val IMAGE_REQUEST_CODE = 100
//    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        thisParent = activity as MainActivity
        return inflater.inflate(R.layout.frag_upload, container, false)
    }

//        override fun onClick(v: View?) {
//        when (v?.id) {
//            R.id.btn_pilihfoto -> {
//                var intentGaleri = Intent()
//                intentGaleri.setType("image/*")
//                intentGaleri.setAction(Intent.ACTION_GET_CONTENT)
//                startActivity(Intent.createChooser(intentGaleri, "PILIH GAMBAR ..."))
//            }
//        }
//    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    upload_cam.setOnClickListener() {
            
        }
    upload_gal.setOnClickListener() {
        var intentGal = Intent(getActivity(), UploadActivity::class.java)
        getActivity()?.startActivity(intentGal)
        }
        }
//    val intent = Intent(Intent.ACTION_PICK)
//    intent.type = "image/"
//    startActivityForResult(intent, IMAGE_REQUEST_CODE)
//    button = thisParent.findViewById(R.id.btn_pilihfoto)
//    imageView = thisParent.findViewById(R.id.upload_image)
//    button.setOnClickListener(this)





    }


//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (requestCode == IMAGE_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
//            imageView.setImageURI(data?.data)
//        }
//    }
