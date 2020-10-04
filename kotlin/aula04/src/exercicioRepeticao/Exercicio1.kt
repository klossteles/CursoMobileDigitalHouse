fun main () {
    print("Quantas notas serão inseridas? ")
    val numeroNotas = readLine()!!.toInt()
    if (numeroNotas > 0) {
        var somaNotas = 0.0
        for (i in 1..numeroNotas) {
            print("Insira a nota: ")
            somaNotas += readLine()!!.toDouble()
        }
        print("Média aritmética igual a ${somaNotas.div(numeroNotas)}")
    } else {
        print("Número de notas inválido.")
    }
}
