private val banco = Banco(ArrayList<ContaBancaria>())
private val TIPO_CONTA_CORRENTE = 1
private val TIPO_CONTA_POUPANCA = 2
private val TAXA_OPERACAO = 5.0
private val LIMITE_OPERACAO = 300.0
private val OPCAO_INVALIDA_STR = "Opção inválida."
private val STR_OPCAO = "Opção: "

fun main () {
    do {
        mostrarMenuPrincipal()
        val opcaoMenuPrincipal = readLine()!!.toInt()
        when(opcaoMenuPrincipal) {
            1 -> criarConta()
            2 -> mostrarConta()
            3 -> removerConta()
            4 -> gerarRelatorios()
            5 -> break
            else -> println(OPCAO_INVALIDA_STR)
        }
    } while (true)
}

fun mostrarMenuPrincipal() {
    println("--------")
    println("1 - Criar conta")
    println("2 - Selecionar conta")
    println("3 - Remover conta")
    println("4 - Gerar relatório")
    println("5 - Finalizar")
    print(STR_OPCAO)
}

fun mostrarMenuConta() {
    println("--------")
    println("a - Depositar")
    println("b - Sacar")
    println("c - Transferir")
    println("d - Gerar relatório")
    println("e - Retornar ao menu principal")
    print(STR_OPCAO)
}

fun criarConta() {
    println("--------")
    do {
        println("Tipo da conta: ")
        println("1 - Corrente")
        println("2 - Poupança")
        val tipoConta = readLine()!!.toInt()
        println("--------")
        when (tipoConta) {
            TIPO_CONTA_CORRENTE -> {
                val numConta = perguntarNumeroConta()
                banco.inserir(ContaCorrente(numConta, 0.0, TAXA_OPERACAO))
                println("Conta crida com sucesso")
                break
            }
            TIPO_CONTA_POUPANCA -> {
                val numConta = perguntarNumeroConta()
                banco.inserir(ContaPoupanca(numConta, 0.0, LIMITE_OPERACAO))
                println("Conta crida com sucesso")
                break
            }
            else -> println(OPCAO_INVALIDA_STR)
        }
    } while (true)
}

fun mostrarConta() {
    println("--------")
    val numConta = perguntarNumeroConta()
    val conta = banco.procurarConta(numConta)
    if (conta != null) {
        do {
            mostrarMenuConta()
            val opcao = readLine()!!
            println("--------")
            when(opcao) {
                "a","A" -> {
                    print("Valor a depositar: ")
                    val valor = readLine()!!.toDouble()
                    conta.depositar(valor)
                }
                "b","B" -> {
                    print("Valor a sacar: ")
                    val valor = readLine()!!.toDouble()
                    conta.sacar(valor)
                }
                "c","C" -> {
                    print("Informe a conta destino: ")
                    val destino = readLine()!!.toInt()
                    val contaDestino = banco.procurarConta(destino)
                    if (contaDestino != null) {
                        print("Valor a transferir: ")
                        val valor = readLine()!!.toDouble()
                        conta.transferir(valor, contaDestino)
                    }
                }
                "d","D" -> {
                    conta.mostrarDados()
                }
                "e","E" -> break
                else -> println(OPCAO_INVALIDA_STR)
            }
        } while (true)
    }
}

fun removerConta() {
    println("--------")
    val numConta = perguntarNumeroConta()
    println("--------")
    val conta = banco.procurarConta(numConta)
    if (conta != null) {
        banco.remover(conta)
        println("Conta removida com sucesso.")
    }
}

private fun perguntarNumeroConta(): Int {
    print("Número da conta: ")
    val numConta = readLine()!!.toInt()
    return numConta
}

fun gerarRelatorios() {
    println("--------")
    banco.mostrarDados()
}
