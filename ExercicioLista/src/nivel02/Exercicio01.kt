package nivel02

import kotlin.math.round
fun main () {
    var numVotos = 0
    var sistemasOperacionais = doubleArrayOf(0.0, 0.0, 0.0, 0.0, 0.0, 0.0)
    var nomes = arrayOf("Windows Server", "Unix", "Linux", "Netware", "Mac OS", "Outro")
    do {
        println("Qual o melhor Sistema Operacional para uso em servidores ")
        println("As possíveis respostas são: ")
        for (i in 0..5) {
            println("${i + 1}- ${nomes.get(i)}")
        }
        println("0- Encerrar pesquisa")
        val opcao = readLine()!!.toInt()
        when(opcao) {
            1,2,3,4,5,6 -> {
                numVotos++
                sistemasOperacionais.set(opcao - 1, sistemasOperacionais[opcao - 1].plus(1.0))
            }
            0 -> break
            else -> print("Opção inválida")
        }
    } while (true)
    println("Sistema Operacional     Votos   %")
    println("-------------------     -----   ---")
    for (i in 0..5) {
        println("${nomes.get(i)}           ${sistemasOperacionais.get(i).toInt()}   ${round((sistemasOperacionais.get(i)*100).div(numVotos))}%")
    }
    println("-------------------     -----")
    println("Total                    $numVotos")

    var nTotal = sistemasOperacionais.max()!!.toDouble()
    for (i in 0..5) {
        if (nTotal == sistemasOperacionais.get(i)) {
            println("O Sisteam Operacional mais votado foi o ${nomes.get(i)}, com valor ${sistemasOperacionais.get(i).toInt()}, correspondendo a ${round((sistemasOperacionais.get(i)*100).div(numVotos))}% dos votos.")
            break
        }
    }
}
