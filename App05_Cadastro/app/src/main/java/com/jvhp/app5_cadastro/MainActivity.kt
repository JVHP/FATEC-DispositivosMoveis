package com.jvhp.app5_cadastro

import android.content.DialogInterface
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.core.view.drawToBitmap

private lateinit var btnCam: Button
private lateinit var btnSalvar: Button

private lateinit var fotoLinda: ImageView

private lateinit var txtNome: TextView
private lateinit var txtIdade: TextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCam = findViewById(R.id.btnCamera)
        btnSalvar = findViewById(R.id.btnSalvar)
        fotoLinda = findViewById(R.id.FotoLinda)
        txtNome = findViewById(R.id.txtNome)
        txtIdade = findViewById(R.id.txtIdade)

        btnCam.setOnClickListener {
            abrirCamera()
        }

        btnSalvar.setOnClickListener {
            val Cadastro = Intent(this@MainActivity, Cadastrado::class.java)

            val usuario = DadosUsuario(nome = txtNome.text.toString(), idade = txtIdade.text.toString().toInt()/*, foto = fotoLinda.drawToBitmap()*/)
            Cadastro.putExtra("USUARIO", usuario)

            startActivity(Cadastro)
        }
    }

    fun abrirCamera(){
        val camera = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

        if(camera.resolveActivity(packageManager) != null){
            startActivityForResult(camera, 12355)

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 12355 && resultCode == RESULT_OK){
            val fotoTirada = data?.extras?.get("data") as Bitmap
            fotoLinda.setImageBitmap(fotoTirada)
        }

    }

    override fun onBackPressed() {
        var dialog = AlertDialog.Builder(this@MainActivity)
        dialog.setTitle("Confirmação")
        dialog.setPositiveButton("Sim", DialogInterface.OnClickListener{dialogInterface, i -> super.onBackPressed()})
        dialog.create().show()

    }
}
