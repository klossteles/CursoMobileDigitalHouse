class Banco(val contas: ArrayList<ContaBancaria>): IImprimivel {
    fun inserir(conta: ContaBancaria) {
        contas.add(conta)
    }

    fun remover(conta: ContaBancaria) {
        if (procurarConta(conta.numConta) != null) {
            contas.remove(conta)
        } else {
            println("Conta inexistente.")
        }
    }

    fun procurarConta(numConta: Int): ContaBancaria? {
        for (conta in contas) {
            if (conta.numConta == numConta) {
                return conta
            }
        }
        println("Conta inexistente.")
        return null
    }

    override fun mostrarDados() {
        for (conta in contas) {
            println("----")
            conta.mostrarDados()
        }
        println("----")
    }
}
