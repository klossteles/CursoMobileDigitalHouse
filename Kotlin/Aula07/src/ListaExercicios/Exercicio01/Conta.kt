package listaExercicios.Exercicio01

class Conta(numeroConta: Int, val titular: Cliente) {
    var saldo: Double = 0.0

    fun depositar(quantia: Double) {
        this.saldo = this.saldo.plus(quantia)
        println("Depósito na conta de ${titular.nomeCompleto} realizado - novo saldo: R\$${this.saldo}")
    }

    fun sacar(quantia: Double) {
        if (quantia.compareTo(this.saldo) > 0) {
            println("Saldo insuficiente")
        } else {
            this.saldo = this.saldo.minus(quantia)
            println("Saque na conta de ${titular.nomeCompleto} realizado - novo saldo: R\$${this.saldo}")
        }
    }
}
