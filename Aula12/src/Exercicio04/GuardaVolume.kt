package Exercicio04

class GuardaVolume {
    val dicionario = mutableMapOf<Int, List<Peca>>()
    var identificador = 0

    fun guardarPecas(listaDePeca: MutableList<Peca>): Int {
        val identificadorAtual = identificador
        identificador++
        dicionario[identificadorAtual] = listaDePeca
        return identificadorAtual
    }

    fun mostrarPecas():Int {
        dicionario.forEach {
            println("Identificador: ${it.key} Peças: ${it.value}")
        }
        return -1
    }

    fun mostrarPecas(numero: Int) {
        if (!dicionario.containsKey(numero)){
            println("Peça inexistente.")
        } else {
            println("Identificador: $numero Peças: ${dicionario[numero]}")
        }
    }

    fun devolverPecas(numero: Int) {
        if (!dicionario.containsKey(numero)) {
            println("Peça inexistente.")
        } else {
            dicionario.remove(numero)
        }
    }
}
