package exercicio02

fun main () {
    val animais: ArrayList<String>? = null
    animais?.add("Pato")
    animais?.add("Cachorro")
    animais?.add("Gato")

    println(animais?.get(2))
}
