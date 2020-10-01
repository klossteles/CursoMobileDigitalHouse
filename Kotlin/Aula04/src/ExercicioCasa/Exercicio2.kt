fun main() {
    print("Quanto vale a sua hora?")
    var valorHora = readLine()!!.toDouble()
    print("Quantas horas você trabalhou?")
    var numHorasTrabalhadas = readLine()!!.toInt()
    print("Você receberá R\$ ${valorHora * numHorasTrabalhadas}")
}
