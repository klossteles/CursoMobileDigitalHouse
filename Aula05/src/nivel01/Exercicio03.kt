package nivel01

fun main() {
    val alturas = ArrayList<Double>()
    for (i in 0..4) {
        print("Informe a altura: ")
        val alturaInformada = readLine()!!.toDouble()
        alturas.add(alturaInformada)
    }

    alturas.reverse()
    alturas.forEach { altura ->
        println("%.2f".format(altura))
    }
}
