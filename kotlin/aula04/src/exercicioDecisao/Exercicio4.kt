fun main() {
    print("Quanto você quer sacar?")
    val valorSaque = readLine()!!.toInt()
    if (valorSaque in 10..600) {
        var resto = valorSaque
        var quantNotasCem: Int
        var quantNotasCinquenta: Int
        var quantNotasDez: Int
        var quantNotasCinco: Int
        var quantNotasUm: Int

        if (valorSaque > 100) {
            quantNotasCem = valorSaque / 100
            resto = valorSaque % 100
            println("$quantNotasCem nota(s) de 100")
        }
        if (resto > 50) {
            quantNotasCinquenta = resto / 50
            resto %= 50
            println("$quantNotasCinquenta nota(s) de 50")
        }
        if (resto > 10) {
            quantNotasDez = resto / 10
            resto %= 10
            println("$quantNotasDez nota(s) de 10")
        }
        if (resto > 5) {
            quantNotasCinco = resto / 5
            resto %= 5
            println("$quantNotasCinco nota(s) de 5")
        }
        if (resto > 1) {
            quantNotasUm = resto
            println("$quantNotasUm nota(s) de 1")
        }
    } else {
        print("Valor inválido!")
    }
}
