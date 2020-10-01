package listaExercicios

fun main () {
    println("Insira o primeiro número: ")
    val numA = readLine()!!.toInt()
    println("Insira o segundo número: ")
    val numB = readLine()!!.toInt()
    println("Insira o terceiro número: ")
    val numC = readLine()!!.toInt()
    println("Insira o quarto número: ")
    val numD = readLine()!!.toInt()
    if (verificaCondicao(numA, numB, numC, numD)) {
        println("Condição verdadeira")
    } else {
        println("Condição falsa")
    }
}

fun verificaCondicao(numA: Int, numB: Int, numC: Int, numD: Int): Boolean {
    if ((numA > numC && numA > numD) || (numB > numC && numB > numD)) {
        return true
    }
    return false
}
