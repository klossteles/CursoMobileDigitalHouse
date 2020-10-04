package exercicio02

fun main () {
    val minhaLista = mutableListOf<Int>()
    minhaLista.add(1)
    minhaLista.add(5)
    minhaLista.add(5)
    minhaLista.add(6)
    minhaLista.add(7)
    minhaLista.add(8)
    minhaLista.add(8)
    minhaLista.add(8)
    println(minhaLista)

    val meuConjunto = mutableSetOf<Int>()
    meuConjunto.add(1)
    meuConjunto.add(5)
    meuConjunto.add(5)
    meuConjunto.add(6)
    meuConjunto.add(7)
    meuConjunto.add(8)
    meuConjunto.add(8)
    meuConjunto.add(8)
    println(meuConjunto)

    minhaLista.forEach {
        println(it)
    }
    println("-------")
    meuConjunto.forEach {
        println(it)
    }
}
