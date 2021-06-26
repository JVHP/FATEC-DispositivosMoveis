package com.jvhp.app7_listausuariosfoto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv = findViewById<RecyclerView>(R.id.rvUsuarios)

        val lista = mutableListOf<Usuario>(
            Usuario(nome = "José", email = "jvhp@gmail.com", stack = Stack.FULLSTACK, senioridade = Senioridade.JUNIOR, foto = resources.getDrawable(R.drawable.minhafoto)),
            Usuario(nome="Macgyver", email="mac@gmail.com", stack= Stack.BACKEND, senioridade= Senioridade.PLENO)
        )

        rv.adapter = UsuarioAdapter(lista)

        rv.layoutManager = LinearLayoutManager(this)


    }
}