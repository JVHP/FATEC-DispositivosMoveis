package com.jvhp.app4_alcoolgasolina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

//Declaração dos componentes
lateinit var rsltCalc: TextView
lateinit var btnCalc: Button
var valGas: Double? = null
var valAlc: Double? = null

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Indica para componente declarado qual componente "fisico" ele siginifica pela id do mesmo
        rsltCalc = findViewById(R.id.resultadoCalc)
        btnCalc = findViewById(R.id.btnCalcular)
        //Realiza uma ação quando o botão for acionado
        btnCalc.setOnClickListener {
            valAlc = findViewById<TextView>(R.id.alcool).text.toString().toDoubleOrNull() //Coverte o texto inserido no input para double
            valGas = findViewById<TextView>(R.id.gasolina).text.toString().toDoubleOrNull()
            CalcularPreco()
        }
    }

    fun CalcularPreco(){
        var result ="" //String do resultado

            valAlc?.let {
                // Realiza se o valAlc nao for null
                valGas?.let {
                    // Realiza se o valGas nao for null
                    var precoT =  valAlc!! / it

                    if (precoT < 0.7) {
                        result = "Melhor utilizar o Álcool"
                    } else {
                        result = "Melhor utilizar a Gasolina"
                    }

                } ?:run {
                    result = "Não deixe o campo Gasolina vazio"
                }
            } ?:run {
                result = "Não deixe o campo Álcool vazio"
            }
            rsltCalc.text = result //Coloca o resultado em string no componente de texto do app

    }
}