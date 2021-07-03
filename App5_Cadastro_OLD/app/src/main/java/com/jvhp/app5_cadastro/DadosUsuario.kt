package com.jvhp.app5_cadastro

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DadosUsuario(val nome: String, val idade: Int) : Parcelable