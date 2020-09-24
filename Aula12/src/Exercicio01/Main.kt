package Exercicio01

fun main () {
    val loteriaDosSonhos = mutableMapOf<Int, String>()
    loteriaDosSonhos[0] = "Ovos"
    loteriaDosSonhos[1] = "Água"
    loteriaDosSonhos[2] = "Escopeta"
    loteriaDosSonhos[3] = "Cavalo"
    loteriaDosSonhos[4] = "Dentista"
    loteriaDosSonhos[5] = "Fogo"


    val apelidos = mutableMapOf<String, List<String>>()
    apelidos["João"] = listOf("Juan","Fissura","Maromba")
    apelidos["Miguel"] = listOf("Night Watch", "Bruce Wayne", "Tampinha")
    apelidos["Maria"] = listOf("Wonder Woman", "Mary", "Marilene")
    apelidos["Lucas"] = listOf("Lukinha", "Jorge", "George")

    apelidos.forEach{
        println("${it.key} -> ${it.value}")
    }
}
