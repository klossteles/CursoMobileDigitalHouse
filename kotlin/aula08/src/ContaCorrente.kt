class ContaCorrente(numConta: Int, saldo: Double, private val taxaDeOperacao: Double) : ContaBancaria
(numConta, saldo) {
    override fun sacar(quant: Double): Boolean {
        if (quant > saldo + taxaDeOperacao) {
            println("Conta Corrente: Saldo insuficiente")
            return false
        } else {
            saldo -= (taxaDeOperacao + quant)
            return true
        }
    }

    override fun depositar(quant: Double): Boolean {
        if ((saldo + quant) >= taxaDeOperacao){
            saldo += quant - taxaDeOperacao
            return true
        } else {
            println("Conta Corrente: Quantidade para depósito inválida.")
            return false
        }
    }

    override fun mostrarDados() {
        super.mostrarDados()
        println("Taxa de operação: $taxaDeOperacao")
    }
}
