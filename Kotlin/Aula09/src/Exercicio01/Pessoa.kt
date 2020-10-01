package Exercicio01

open class Pessoa(val nome: String, val registro: String) {
    open val podeFazerLicao get() = false
    open val podeAssistirAula get() = false
    open val podeDarAula get() = false
    open val podeFazerChamada get() = false
}
