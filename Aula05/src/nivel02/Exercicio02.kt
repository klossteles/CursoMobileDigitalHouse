package nivel02

fun main() {
    val nomesNotas = arrayOf("cem", "cinquenta", "dez", "cinco", "um")
    val valoresNotas = intArrayOf(100, 50, 10, 5, 1)
    print("Quanto você quer sacar? ")
    var valorSaque = readLine()!!.toInt()
    if (valorSaque in 10..600) {
        for (i in 0..4) {
            if ((valorSaque / valoresNotas.get(i)) > 0) {
                println("${valorSaque / valoresNotas.get(i)} nota(s) de ${nomesNotas.get(i)}")
                valorSaque = valorSaque % valoresNotas.get(i)
            }
        }
    } else {
        print("Valor inválido!")
    }
}
