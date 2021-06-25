package com.jvhp.app5_cadastro
import android.graphics.Bitmap
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DadosUsuario(val nome: String, val idade: Int/*, val foto: Bitmap*/) : Parcelable