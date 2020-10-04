fun main() {
    print("Digite a nota 1: ")
    var nota1 = readLine()!!.toDouble()
    print("Digite a nota 2:")
    var nota2 = readLine()!!.toDouble()
    print("Digite a nota 3:")
    var nota3 = readLine()!!.toDouble()
    print("Digite a nota 4:")
    var nota4 = readLine()!!.toDouble()
    val somaNotas = nota1 + nota2 + nota3 + nota4;
    print("A média é ${somaNotas.div(4)}")
}
