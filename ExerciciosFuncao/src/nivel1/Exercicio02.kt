package nivel1

fun main () {
    print("Insira um número: ")
    val numero = readLine()!!.toInt()
    print(checaPositivoNegativo(numero))
}
fun checaPositivoNegativo(numero: Int) = if (numero > 0) "P" else "N"
