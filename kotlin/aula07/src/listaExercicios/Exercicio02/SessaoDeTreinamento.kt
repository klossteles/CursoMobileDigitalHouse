package listaExercicios.Exercicio02

class SessaoDeTreinamento {
    var experiencia: Int = 0

    fun treinarA(jogador: JogadorDeFutebol) {
        val expInicial = jogador.experiencia
        jogador.correr()
        jogador.fazerGol()
        jogador.correr()
        jogador.experiencia += 1
        println("Exp. inicial: $expInicial - Exp. final: ${jogador.experiencia}")
    }
}
