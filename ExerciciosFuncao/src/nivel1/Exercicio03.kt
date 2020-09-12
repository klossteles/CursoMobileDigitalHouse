package nivel1

fun main () {
    print("Insira o valor do produto: ")
    val custo = readLine()!!.toDouble()
    print("Insira a taxa de imposto(%): ")
    val taxaImposto = readLine()!!.toDouble()
    val valorTaxado = somaImposto(taxaImposto, custo)
    print("Valor do produto taxado: $valorTaxado")
}

fun somaImposto(taxaImposto: Double, custo: Double): Double {
    return custo + custo*(taxaImposto.div(100))
}
