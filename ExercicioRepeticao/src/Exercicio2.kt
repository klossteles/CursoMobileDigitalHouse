fun main () {
    print("Quantidade de CDs? ")
    val quantCDs = readLine()!!.toInt()
    if (quantCDs > 0) {
        var somaValorCDs = 0.0
        for (i in 1..quantCDs) {
            print("Insira o valor do CD $i: ")
            somaValorCDs += readLine()!!.toDouble()
        }
        println("Valor total da coleção: R\$${"%.2f".format(somaValorCDs)}")
        print("Média dos CDs igual a R\$${"%.2f".format(somaValorCDs.div(quantCDs))}")
    } else {
        print("Número de CDs inválido.")
    }

}
