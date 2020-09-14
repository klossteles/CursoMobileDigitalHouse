fun main() {
    print("Digite o peso dos peixes: ")
    val pesoPeixes = readLine()!!.toDouble()
    val excessoPeixes = pesoPeixes - 50
    val multa = excessoPeixes * 4
    println("Excedeu ${excessoPeixes}Kg")
    print("O Valor a ser pago é de R\$ ${multa}")
}
