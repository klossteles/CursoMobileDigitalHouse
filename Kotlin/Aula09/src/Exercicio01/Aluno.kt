package exercicio01

class Aluno(registro: String, nome: String, sobrenome: String): Pessoa(nome, registro) {
    var nomeCompleto: String
    init {
        nomeCompleto = "$nome $sobrenome"
    }

    override val podeFazerLicao: Boolean
        get() = true
    override val podeAssistirAula: Boolean
        get() = true

//    val licoesCasa = ArrayList<LicaoCasa>()
//    fun assistirAula(aula: Aula) {
//        println("O aluno $nomeCompleto está participando da aula ${aula.materia.nome}")
//    }
//    fun fazerLicaoCasa() {-
//        licoesCasa.forEach {
//            println("O aluno $nomeCompleto está fazendo a lição da aula ${it.aula.materia.nome}")
//        }
//    }
}
