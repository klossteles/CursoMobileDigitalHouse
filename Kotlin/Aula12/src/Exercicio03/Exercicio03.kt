package Exercicio03

fun main () {
    val conjuntoDeInteiros = mutableSetOf<Int>()
    conjuntoDeInteiros.add(1)
    conjuntoDeInteiros.add(2)
    conjuntoDeInteiros.add(3)
    conjuntoDeInteiros.add(4)
    conjuntoDeInteiros.add(5)
    conjuntoDeInteiros.add(1)
    conjuntoDeInteiros.add(2)
    conjuntoDeInteiros.forEach {
        println(it)
    }
    println("------")
    print("Total: ")
    Prova().somaTotal(conjuntoDeInteiros)
}
