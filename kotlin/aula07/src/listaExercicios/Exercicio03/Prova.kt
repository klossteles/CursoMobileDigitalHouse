package listaExercicios.Exercicio03

class Prova(var dificuldade: Int, var energiaNecessaria: Int) {
    fun realizarProva(atleta: Atleta): Boolean {
        if (atleta.nivel >= dificuldade && atleta.energia >= energiaNecessaria) {
            atleta.energia = atleta.energia - energiaNecessaria
            println("Atleta ${atleta.nome} pode realizar a prova. Energia após prova: ${atleta.energia}")
            return true
        } else {
            println("Atleta ${atleta.nome} não pode realizar a prova. Energia necessária/Energia atleta: $energiaNecessaria/${atleta.energia}")
        }
        return false
    }
}
