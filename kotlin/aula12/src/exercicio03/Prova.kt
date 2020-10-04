package exercicio03

class Prova {
    fun somaTotal(conjuntoDeInteiros: MutableSet<Int>){
        var total = 0
        conjuntoDeInteiros.forEach {
            total += it
        }
        println(total)
    }
}
