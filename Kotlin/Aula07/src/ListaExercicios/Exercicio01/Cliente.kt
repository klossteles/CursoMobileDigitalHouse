package listaExercicios.Exercicio01

class Cliente (nome: String, sobrenome: String) {
    val nomeCompleto: String
    init {
        nomeCompleto = "$nome $sobrenome"
    }
}
