package exercicio03

import kotlin.math.max

class Estoque(var nome: String, var qtdAtual: Int, var qtdMinima: Int) {
    init {
        qtdAtual = max(0, qtdAtual)
        qtdMinima = max(0, qtdMinima)
    }

    fun mudarNome(nome: String){
        this.nome = nome
    }

    fun mudarQtdMinima(qtdMinima: Int) {
        if (qtdMinima < 0) {
            println("Quantidade mínima inválida.")
        }
        this.qtdMinima = qtdMinima
    }

    fun repor(qtd: Int) {
        if (qtd > 0) {
            qtdAtual += qtd
        } else {
            println("Quantidade inválida.")
        }
    }

    fun darBaixa(qtd: Int) {
        if (qtdAtual - qtd > 0) {
            qtdAtual -= qtd
        } else {
            println("Quantidade inválida.")
        }
    }

    fun mostra(): String {
        return "Nome: $nome\nQtd. mínima: $qtdMinima\nQtd. atual: $qtdAtual"
    }

    fun precisaRepor() = qtdAtual <= qtdMinima
}
