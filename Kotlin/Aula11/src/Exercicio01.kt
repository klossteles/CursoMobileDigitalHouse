import java.lang.Exception

fun main() {
    val animais = ArrayList<String>()
    animais.add("Pato")
    animais.add("Cachorro")
    animais.add("Gato")
    try {
        println(animais.get(3))
    } catch (ex: Exception) {
        println(ex.printStackTrace())
    }
}
