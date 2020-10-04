package listaExercicios

fun main () {
    print("Insira um número: ")
    val numero = readLine()!!.toInt()
    if (verificaNumeroPar(numero)) {
        println("Número é par")
    } else {
        println("Número é ímpar")
    }
}
fun verificaNumeroPar (numero: Int) = (numero % 2) == 0
