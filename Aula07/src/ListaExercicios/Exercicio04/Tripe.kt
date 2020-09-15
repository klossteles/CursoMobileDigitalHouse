package ListaExercicios.Exercicio04

class Tripe(var dobrado:Boolean, var alturaMinima: Int, var alturaMaxima: Int, var alturaAtual: Int) {
    fun definiarAltura(novaAltura: Int) {
        alturaAtual = novaAltura
    }
    fun dobrar() {
        dobrado = true
    }

    fun desdobrar() {
        dobrado = false
    }

    fun guardar() {
        dobrado = true
        alturaAtual = alturaMinima
    }

    fun prontoParaGuardar() = dobrado && alturaMinima == alturaAtual

    fun usar() {
        dobrado = false
        alturaAtual = (alturaMaxima / 2) + 1
    }

    fun prontoParaUsar() = !dobrado && alturaAtual > (alturaMaxima / 2)
}
