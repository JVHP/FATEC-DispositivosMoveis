package com.jvhp.app20_github_r_sp.data.model

import com.google.gson.annotations.SerializedName
import java.text.SimpleDateFormat
import java.util.*

class Github(@SerializedName("id") val id: String,
             @SerializedName("login") val nome: String,
             @SerializedName("public_repos") val repositorios: String,
             @SerializedName("created_at") val criacao: Date,
             @SerializedName("followers") val seguidores: String,
             @SerializedName("following") val seguindo: String,
             @SerializedName("avatar_url") val foto: String) {

    override fun toString(): String {
        val newstring: String = SimpleDateFormat("dd/MM/yyyy").format(criacao)
        println(newstring) // 2011-01-18

        return "$nome\nId: $id\nRepositórios: $repositorios\nCriado em: $newstring\nSeguidores: $seguidores\nSeguindo: $seguindo"
    }

    fun picToString(): String {
        return "$foto"
    }

}