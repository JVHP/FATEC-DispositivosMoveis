package com.jvhp.app5_cadastro

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView

lateinit var btnCam: Button
lateinit var btnSalvar: Button

lateinit var fotoLinda: ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCam = findViewById<Button>(R.id.btnCamera)
        btnSalvar = findViewById<Button>(R.id.btnSalvar)
        fotoLinda = findViewById<ImageView>(R.id.FotoLinda)

        btnCam.setOnClickListener {
            abrirCamera()
        }

        btnSalvar.setOnClickListener {
            val Cadastro = Intent(this@MainActivity,
            Cadastrado::class.java)
            startActivity(Cadastro)
        }
    }

    fun abrirCamera(){
        val camera = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

        if(camera.resolveActivity(packageManager) != null){
            startActivityForResult(camera, 12345)

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 12345 && resultCode == RESULT_OK){
            val fotoTirada = data?.extras?.get("data") as Bitmap
            fotoLinda.setImageBitmap(fotoTirada)
        }

    }

    override fun onStart() {
        super.onStart()
    }
}
