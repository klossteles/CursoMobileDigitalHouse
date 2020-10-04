package listaExercicios.Exercicio5

class Cliente(val nome: String, val sobrenome: String, val contato: String) {
    val nomeCompleto: String
    init {
        nomeCompleto = "$nome $sobrenome"
    }
}
