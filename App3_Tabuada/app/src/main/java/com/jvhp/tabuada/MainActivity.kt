package com.jvhp.tabuada

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.io.IOException
import java.lang.Exception
import java.lang.NullPointerException
import java.util.*
import java.util.concurrent.ExecutionException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun TabuadaSorteio(view: View){
        var texto = findViewById(R.id.txtNumero) as TextView
        var Resultado = findViewById(R.id.textViewResult) as TextView
        var numeroSorteado = Random().nextInt(11)
        var result = " "

            texto.setText("A tabuada de $numeroSorteado é")
            for (i in (1..10)) {
                result = result + "$numeroSorteado" + " x " + i + " = " + (numeroSorteado * i) + "\n"
            }
            Resultado.setText("$result")
        }

    fun TabuadaReal(view: View){
        var n = findViewById(R.id.nTabuada) as TextView //número digitado pelo User
        var texto = findViewById(R.id.txtNumero) as TextView //Texto explicativo
        var Resultado = findViewById(R.id.textViewResult) as TextView //Texto onde aparecerá o resultado
        try{
            var numeroTab = Integer.parseInt(n.getText().toString()) //Converte o número digitado pelo User em Integer
            var result = "" //Aqui ficará o retorno em String que o TextView pede
            if (numeroTab>10) {
                n.setError("Digite um valor entre 0 e 10")
                n.requestFocus()
            }
            else{
                texto.setText("A tabuada de $numeroTab é")
                for (i in (1..10)) {
                    result += "$numeroTab" + "X" + i + " = " + (numeroTab * i) + "\n"
                }
                Resultado.setText("$result")
            }
        }catch(ex: Exception){
                n.setError("Não deixe em branco!!")
                n.requestFocus()
            }
        }

}