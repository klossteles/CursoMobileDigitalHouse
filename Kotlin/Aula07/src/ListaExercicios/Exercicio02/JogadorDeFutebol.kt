package listaExercicios.Exercicio02

class JogadorDeFutebol(nome: String, var energia: Int, var alegria: Int, var experiencia: Int) {
    var gols: Int = 0

    fun fazerGol() {
        this.gols += 1
        this.energia -= 5
        this.alegria += 10
        println("GOOOOL!")
    }

    fun correr() {
        this.energia -= 10
        println("Cansei")
    }
}
