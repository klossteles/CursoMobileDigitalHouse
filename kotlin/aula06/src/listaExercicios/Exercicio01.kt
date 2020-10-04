package listaExercicios

fun main () {
    println("Insira o primeiro número: ")
    val primeiroNumero = readLine()!!.toInt()
    println("Insira o segundo número: ")
    val segundoNumero = readLine()!!.toInt()
    println("Insira o terceiro número: ")
    val terceiroNumero = readLine()!!.toInt()
    println("Maior número: ${getMaiorNumero(primeiroNumero, segundoNumero, terceiroNumero)}")
}

fun getMaiorNumero(primeiroNumero: Int, segundoNumero: Int, terceiroNumeo: Int): Int {
    if (primeiroNumero > segundoNumero && primeiroNumero > terceiroNumeo) {
        return primeiroNumero
    } else if (segundoNumero > terceiroNumeo) {
        return segundoNumero
    } else {
        return terceiroNumeo
    }
}
