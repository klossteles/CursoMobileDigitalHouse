fun main() {
//    NÍVEL 1
//    print("Insira um número: ")
//    var numero = readLine()!!.toInt()
//    println("O número informado foi ${numero}")

//    print("Insira um número: ")
//    var numero1 = readLine()!!.toInt()
//    print("Insira um outro número: ")
//    var numero2 = readLine()!!.toInt()
//    println("$numero1 + $numero2 = ${numero1 + numero2}")

//    print("Insira quantos metros: ")
//    var metros = readLine()!!.toInt()
//    println("$metros metro = ${metros*100} centímetros")

//    NÍVEL 2
//    print("Insira temperatura em Fahrenheit: ")
//    var tempFahrenheit = readLine()!!.toInt()
//    println("A temperatura em Celsius é ${5*((tempFahrenheit-32)/9)}")

    print("Quanto você recebe por hora? ")
    var valorPorHora = readLine()!!.toDouble()
    print("Quantas horas você trabalha por mês? ")
    var horasPorMes = readLine()!!.toDouble()
    val salarioBruto = valorPorHora * horasPorMes
    val valorImpostoRenda = salarioBruto - (salarioBruto * 0.89)
    val valorInss = salarioBruto - (salarioBruto * 0.92)
    val valorSindicato = salarioBruto - (salarioBruto * 0.95)
    println("+ Salário Bruto : R\$${salarioBruto}")
    println("- IR (11%) : R\$$valorImpostoRenda")
    println("- INSS (8%) : R\$$valorInss")
    println("- Sindicato (5%) : R\$$valorSindicato")
    println("= Salário Líquido : R\$${salarioBruto - (valorImpostoRenda + valorInss + valorSindicato)}")
}
