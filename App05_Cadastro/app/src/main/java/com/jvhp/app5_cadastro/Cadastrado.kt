package com.jvhp.app5_cadastro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.jvhp.app5_cadastro.DadosUsuario

lateinit var btnReturn: Button

class Cadastrado : AppCompatActivity() {
    lateinit var Dados: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastrado)

        btnReturn = findViewById<Button>(R.id.btnVoltar)
        Dados = findViewById<TextView>(R.id.DadosUsuario)

        val usuario = intent.extras?.get("USUARIO") as DadosUsuario

        listaUsuario.add(usuario)

        Dados.text = listaUsuario.toString()

        Toast.makeText(this, usuario.nome, Toast.LENGTH_LONG).show()

        btnReturn.setOnClickListener {
            val Voltar = Intent(
                this@Cadastrado,
                MainActivity::class.java
            )
            startActivity(Voltar)
        }
    }

    companion object{
        var listaUsuario = mutableListOf<DadosUsuario>()
    }

}