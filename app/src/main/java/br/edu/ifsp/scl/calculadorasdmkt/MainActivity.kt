package br.edu.ifsp.scl.calculadorasdmkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var concatenaLcd: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Primeira linha de botão
        seteBt.setOnClickListener(this)
        oitoBt.setOnClickListener(this)
        noveBt.setOnClickListener(this)
        somaBt.setOnClickListener(this)


        //Terceira linha de botão
        umBt.setOnClickListener {
            if (!concatenaLcd){
                lcdTv.text = ""
            }

            lcdTv.append((it as Button).text.toString())
            concatenaLcd = true
        }

        doisBt.setOnClickListener { it ->
            if (!concatenaLcd){
                lcdTv.text = ""
            }

            lcdTv.append((it as Button).text.toString())
            concatenaLcd = true
        }

        tresBt.setOnClickListener { botao: View ->
            if (!concatenaLcd){
                lcdTv.text = ""
            }

            lcdTv.append((botao as Button).text.toString())
            concatenaLcd = true
        }

        multiplicacaoBt.setOnClickListener(object: View.OnClickListener {
            override fun onClick(p0: View?) {
                lcdTv.text = Calculadora.calcula(
                    lcdTv.text.toString().toFloat(), Operador.MULTIPLICACAO
                ).toString()
                concatenaLcd = false
            }
        })

        //Primeiro modo
        zeroBt.setOnClickListener(::onClickZeroPontoResultadoDivisao)
        //Segundo modo
        pontoBt.setOnClickListener{::onClickZeroPontoResultadoDivisao}
        resultadoBt.setOnClickListener(::onClickZeroPontoResultadoDivisao)
        divisaoBt.setOnClickListener(::onClickZeroPontoResultadoDivisao)

    }

    // Quarta linha de botão

    fun onClickZeroPontoResultadoDivisao(view: View?) {
        when (view){
            zeroBt -> {
                // Limpa LCD se último clicado foi um operador
                if (!concatenaLcd) {
                    lcdTv.text = ""
                }
                lcdTv.append((view as Button).text.toString())
                concatenaLcd = true
            }
            pontoBt -> {
                if (!lcdTv.text.toString().contains(".")){
                    if (!concatenaLcd) {
                        lcdTv.text = "0"
                    }
                    lcdTv.append(".")
                    concatenaLcd = true
                }
            }
            resultadoBt -> {
                lcdTv.text = Calculadora.calcula(
                    lcdTv.text.toString().toFloat(),
                    Operador.RESULTADO
                ).toString()
                concatenaLcd = false
            }
            divisaoBt -> {
                lcdTv.text = Calculadora.calcula(
                    lcdTv.text.toString().toFloat(),
                    Operador.DIVISAO
                ).toString()
                concatenaLcd = false
            }
        }
    }



    override fun onClick(p0: View?) {
        if (p0 == seteBt || p0 == oitoBt || p0 == noveBt) {
            if (!concatenaLcd){
                lcdTv.text = ""
            }

            lcdTv.append((p0 as Button).text.toString())
            concatenaLcd = true
        }
        else {
            if (p0 == somaBt) {
                lcdTv.text = Calculadora.calcula(
                    lcdTv.text.toString().toFloat(), Operador.ADICAO
                ).toString()
                concatenaLcd = false
            }
        }
    }

    fun onClickBtNum(p0: View?) {
        if (!concatenaLcd){
            lcdTv.text = ""
        }

        lcdTv.append((p0 as Button).text.toString())
        concatenaLcd = true

    }

    fun onClickBtSub(p0: View) {
        if (p0 == somaBt) {
            lcdTv.text = Calculadora.calcula(
                lcdTv.text.toString().toFloat(), Operador.SUBTRACAO
            ).toString()
            concatenaLcd = false
        }
    }

    fun onClickBtRaiz(p0: View) {
        if(p0 == raizBt) {
            lcdTv.text = Calculadora.calcula(
                lcdTv.text.toString().toFloat(), Operador.RAIZ
            ).toString()
            concatenaLcd = false
        }
    }

    fun onClickBtPorcentagem(p0: View) {
        if(p0 == porcentagemBt) {
            lcdTv.text = Calculadora.calcula(
                lcdTv.text.toString().toFloat(), Operador.PORCENTAGEM
            ).toString()
            concatenaLcd = false
        }
    }

    fun onClickBtClear(p0: View) {
        if(p0 == limpezaBt) {
            lcdTv.text = ""
            concatenaLcd = false
        }
    }

    fun onClickBtCancelEntry(p0: View) {
        if(p0 == limpezaOperacaoBt) {
            lcdTv.text = ""
            concatenaLcd = false
        }
    }
}
