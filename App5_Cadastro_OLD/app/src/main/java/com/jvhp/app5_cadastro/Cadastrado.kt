package com.jvhp.app5_cadastro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

lateinit var btnReturn: Button

class Cadastrado : AppCompatActivity() {
    lateinit var Dados: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastrado)

        btnReturn = findViewById<Button>(R.id.btnVoltar)

        btnReturn.setOnClickListener {
            val Voltar = Intent(
                this@Cadastrado,
                MainActivity::class.java
            )
            startActivity(Voltar)
        }

    }

}