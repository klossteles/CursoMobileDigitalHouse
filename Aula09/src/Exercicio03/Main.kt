package Exercicio03

fun main () {
    var estoque = Estoque("Manutenção", 0, 0)
    estoque.darBaixa(-1)
    estoque.repor(10)
    println("------")
    println(estoque.mostra())
    estoque.mudarQtdMinima(-5)
    estoque.mudarQtdMinima(5)
    println("------")
    println(estoque.mostra())
    estoque.darBaixa(5)
    println("------")
    println(estoque.mostra())
    if (estoque.precisaRepor()) {
        println("Precisa repor.")
    } else {
        println("Não precisa repor.")
    }
    println("------")
    estoque.repor(1)
    println(estoque.mostra())
    if (estoque.precisaRepor()) {
        println("Precisa repor.")
    } else {
        println("Não precisa repor.")
    }

    println("------")
    estoque.mudarNome("Reposição")
    println(estoque.mostra())
}
