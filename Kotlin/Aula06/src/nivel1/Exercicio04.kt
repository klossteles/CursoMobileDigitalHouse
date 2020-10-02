package nivel1
import kotlin.random.Random

fun main() {
    var rodada = 1
    var ultimoSorteado = 0
    do {
        println("Rolar dados? (s ou n)" )
        val opcao = readLine()!!
        if (opcao.equals("n", true)) {
            break
        }
        val numeroSorteado = getNumeroAleatorio()
        if (rodada == 1){
            if (numeroSorteado == 7 || numeroSorteado == 11) {
                println("Você tirou ${numeroSorteado}! Parabéns você ganhou!")
                break
            } else if (numeroSorteado == 2 || numeroSorteado == 3 || numeroSorteado == 12) {
                println("Você tirou ${numeroSorteado}! Craps! Você perdeu =(")
                break
            }
            ultimoSorteado = numeroSorteado
        } else {
            if (ultimoSorteado == numeroSorteado) {
                println("Você tirou ${numeroSorteado}! Parabéns você ganhou!")
                break
            }
        }
        println("Você tirou ${numeroSorteado}! Aperte enter para tentar novamente")
        readLine()
        rodada++
    } while (true)
}

fun getNumeroAleatorio() = Random.nextInt(2, 12)
