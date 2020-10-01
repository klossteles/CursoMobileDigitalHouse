package Exercicio04

abstract class Peca(val marca: String, val modelo: String) {
    abstract fun retirada()
    override fun toString(): String {
        return "Peca(marca='$marca', modelo='$modelo')"
    }
}
