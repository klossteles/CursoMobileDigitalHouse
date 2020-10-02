package exercicio01

class Professor(nome: String, registro: String ): Pessoa(nome, registro) {
    override val podeDarAula: Boolean
        get() = true

    override val podeFazerChamada: Boolean
        get() = true

//    fun darAula(aula: Aula) {
//        println("Professor $nome está dando a aula ${aula.materia.nome}.")
//    }
//    fun fazerChamada(aula: Aula) {
//        println("Professor $nome está fazendo a chamada.")
//    }
}
