package br.edu.ifsp.scl.calculadorasdmkt

import java.lang.Math.*
import kotlin.math.sqrt

/* Classe de enumeração para constantes de operadores */
enum class Operador {
    RESULTADO, ADICAO, SUBTRACAO, MULTIPLICACAO, DIVISAO, PORCENTAGEM, RAIZ, CLEAR, CANCELENTRY
}

/* Singleton que calcula operações aritméticas básicas */
object Calculadora {
    // primeiro operando
    var operando: Float = 0.0f

    // operador que será aplicado entre primeiro e segundo operando
    var operador: Operador = Operador.RESULTADO

    /* calcula um valor de retorno com base no operando e operador já existentes, novo valor
     e atualiza valor de operando e operador */
    fun calcula(valor: Float, operador: Operador): Float {
        when (this.operador) {
            Operador.RESULTADO -> operando = valor
            Operador.ADICAO -> operando += valor
            Operador.SUBTRACAO -> operando -= valor
            Operador.MULTIPLICACAO -> operando *= valor
            Operador.DIVISAO -> operando /= valor
            Operador.PORCENTAGEM -> operando *= valor/100
            Operador.RAIZ -> operando = sqrt(valor)
            Operador.CLEAR -> operando = valor
            Operador.CANCELENTRY -> operando = valor

        }
        this.operador = operador
        return operando
    }
}