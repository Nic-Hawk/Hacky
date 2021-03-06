package com.hawk.hacky.view

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.bumptech.glide.Glide
import com.hawk.hacky.R
import com.hawk.hacky.databinding.ActivityDetalleBinding
import com.hawk.hacky.databinding.ActivityLoginBinding

class DetalleActivity : AppCompatActivity() {

        private lateinit var binding: ActivityDetalleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val img = intent.getStringExtra("img")
        val link = intent.getStringExtra("link")
        val nombre = intent.getStringExtra("nombre")
        val descripcion = intent.getStringExtra("desc")

        loadInfo(nombre, descripcion, img, link)
    }

    private fun loadInfo(nombre:String?, desc:String?, img:String?, link:String?) {
        Glide.with(binding.imageView3.context).load(img).into(binding.imageView3)
        binding.tvName.text = nombre
        binding.tvdesc.text = desc
        binding.linkbox.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse(link)
            startActivity(openURL)
        }
        binding.cellbox.setOnClickListener{
            var number = "+505 5760 6175"
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel: $number")
            startActivity(intent)
        }

    }


}