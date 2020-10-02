import java.math.RoundingMode

fun main() {
    print("Digite a altura:")
    var altura = readLine()!!.toDouble()
    println("Para homens: ${((72.7 * altura) - 58).toBigDecimal().setScale(2, RoundingMode.DOWN).toDouble()}")
    print("Para mulheres: ${((62.1 * altura) - 44.7).toBigDecimal().setScale(2, RoundingMode.DOWN).toDouble()}")
}
