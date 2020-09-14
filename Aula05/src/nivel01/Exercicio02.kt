package nivel01

fun main() {
    val numeros = intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
    numeros.reverse()
    numeros.forEach { numero ->
        println(numero)
    }
}
