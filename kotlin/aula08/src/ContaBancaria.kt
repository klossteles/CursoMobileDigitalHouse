abstract class ContaBancaria(val numConta: Int, protected var saldo: Double): IImprimivel {
    abstract fun sacar(quant: Double): Boolean
    abstract fun depositar(quant: Double): Boolean

    override fun mostrarDados() {
        println("Número da conta: $numConta")
        println("Saldo: $saldo")
    }

    fun transferir(valor: Double, destino: ContaBancaria) {
        val saldoContaOrigem = saldo
        if (!sacar(valor) || !destino.depositar(valor)){
            saldo = saldoContaOrigem
            println("Operação cancelada.")
        }
    }
}
