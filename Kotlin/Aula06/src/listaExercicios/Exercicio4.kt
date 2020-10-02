package listaExercicios

fun main () {
    var contador = 0
    var num = 0
    while (contador != 100) {
        if (verificaSeImpar(num)) {
            contador += 1
            println(num)
        }
        num++
    }
}

fun verificaSeImpar(num: Int) = num % 2 != 0
