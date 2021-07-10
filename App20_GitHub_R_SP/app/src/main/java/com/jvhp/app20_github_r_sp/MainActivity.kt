package com.jvhp.app20_github_r_sp

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.bumptech.glide.Glide
import com.jvhp.app20_github_r_sp.domain.GithubService
import com.jvhp.app20_github_r_sp.util.Network
import kotlinx.coroutines.*
import java.lang.System.console

class MainActivity : AppCompatActivity() {

    private lateinit var campoLogin: EditText
    private lateinit var botaoLogin: Button
    private lateinit var respostaLogin: TextView
    private lateinit var carregamentoLogin: ProgressBar
    private lateinit var avatar: ImageView
    private lateinit var corzinha: RelativeLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        campoLogin = findViewById(R.id.edtLogin)
        botaoLogin = findViewById(R.id.btnBuscarUsuario)
        respostaLogin = findViewById(R.id.txtUserResponse)
        carregamentoLogin = findViewById(R.id.prgLoading)
        avatar = findViewById(R.id.avatar)
        corzinha = findViewById(R.id.corzinha)
        corzinha.visibility = View.INVISIBLE

        botaoLogin.setOnClickListener{
            val usuario = campoLogin.text.toString()
            if(usuario.isNotEmpty()){
                buscarUsuario(usuario)
            } else {
                campoLogin.error = "Digite um usuário válido"
            }
        }
    }

    fun buscarUsuario(login: String){
        val retrofitClient = Network.retrofitConfig("https://api.github.com/users/")
        val servico = retrofitClient.create(GithubService::class.java)

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = servico.buscarUsuario(login)

                withContext(Dispatchers.Main){
                    changeLoadingVisibility(isVisible = true)
                    delay(2000L)
                    if(response.isSuccessful){
                        changeLoadingVisibility(isVisible = false)
                        respostaLogin.text = response.body().toString()
                        Glide.with(this@MainActivity).load(response.body()?.picToString()).into(avatar)

                        corzinha.visibility = View.VISIBLE
                    }
                }
            }catch (e: Exception){
                withContext(Dispatchers.Main){
                    changeLoadingVisibility(isVisible = false)
                    respostaLogin.text = "Não foi possível processar a sua solicitação."
                }
            }
        }
    }
    fun changeLoadingVisibility(isVisible: Boolean){
        if(isVisible){
            respostaLogin.text = ""
            carregamentoLogin.visibility = View.VISIBLE
            botaoLogin.visibility = View.INVISIBLE
            avatar.visibility = View.INVISIBLE
            corzinha.visibility = View.INVISIBLE

        } else {
            carregamentoLogin.visibility = View.INVISIBLE
            botaoLogin.visibility = View.VISIBLE
            avatar.visibility = View.VISIBLE
            corzinha.visibility = View.VISIBLE
        }
    }
}