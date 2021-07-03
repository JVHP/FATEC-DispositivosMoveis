package com.jvhp.app13_whatsapp2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.*



class Conversas : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_conversas, container, false)

        val rv = v.findViewById<RecyclerView>(R.id.rvUsuarios)

        val lista = mutableListOf<Usuario>(
            Usuario(nome = "José", conversa = "José: HAHAHA"),
            Usuario(nome="Macgyver", conversa = "Macgyver: HAHAHA"),
            Usuario(nome = "Gabriel", conversa = "Gabriel: HAHAHA"),
            Usuario(nome="João", conversa = "João: HAHAHA"),
            Usuario(nome = "Marcos", conversa ="Marcos: HAHAHA"),
            Usuario(nome="Tamires", conversa = "Tamires: HAHAHA"),
            Usuario(nome = "Joseff", conversa = "Joseff: HAHAHA"),
            Usuario(nome="Candido", conversa = "Candido: HAHAHA"),
            Usuario(nome = "Joseleine", conversa = "Joseleine: HAHAHA"),
            Usuario(nome="Maria", conversa = "Maria: HAHAHA"),
            Usuario(nome = "Leticia", conversa = "Leticia: HAHAHA"),
            Usuario(nome="Armando", conversa = "Armando: HAHAHA"),


        )
        rv.adapter = UsuarioAdapter(lista)

        rv.layoutManager = LinearLayoutManager(context)

        return v
    }

}