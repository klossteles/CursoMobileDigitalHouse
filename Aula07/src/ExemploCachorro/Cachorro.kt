class Cachorro (nome: String, sobrenome: String) {
    val nomeCompleto: String
    var cor: String = ""
    var anoNasc: Int = 0
    val idade: Int

    init {
        nomeCompleto = "$nome $sobrenome"
        idade = 2020 - anoNasc
    }
    constructor(nomeDoCachorro: String, anoNasc: Int): this(nomeDoCachorro, "") {
        this.anoNasc = anoNasc
    }

    fun calculaIdade(): Int {
        return 2020 - anoNasc
    }
}
