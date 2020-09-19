package Exercicio02

import kotlin.math.max

class Item(val numero: Int, val descricao: String, var quantidade: Int, var precoUnitario: Double) {
    init {
//        if (quantidade < 0) {
//            quantidade = 0
//        }
//        if (precoUnitario.compareTo(0) < 0) {
//            precoUnitario = 0.0
//        }
        quantidade = max(0, quantidade)
        precoUnitario = max(0.0, precoUnitario)
    }
}
