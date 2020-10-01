class ContaPoupanca(numConta: Int, saldo: Double, private val limite:Double): ContaBancaria(numConta, saldo) {
    override fun sacar(quant: Double): Boolean {
        if (quant <= (saldo + limite)) {
            saldo -= quant
            return true
        } else {
            println("Conta Poupança: Saldo insuficiente")
            return false
        }
    }

    override fun depositar(quant: Double): Boolean {
        saldo += quant
        return true
    }

    override fun mostrarDados() {
        super.mostrarDados()
        println("Limite: $limite")
    }
}
