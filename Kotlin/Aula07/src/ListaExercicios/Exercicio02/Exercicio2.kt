package ListaExercicios.Exercicio02

fun main() {
    val jogador1 = JogadorDeFutebol("Ronaldinho", 100, 100, 70)
    val jogador2 = JogadorDeFutebol("Durval", 100, 10, 60)
    val sessaoTreinamento = SessaoDeTreinamento()
    sessaoTreinamento.treinarA(jogador1)
    sessaoTreinamento.treinarA(jogador2)
}
