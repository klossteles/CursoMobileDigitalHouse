package exercicio04

fun main () {
    val guardaVolume = GuardaVolume()
    var minhasPecas = mutableListOf<Pertence>(Pertence("Umbro", "Hoodie"), Pertence("Volcom", "Moletom"))
    println(guardaVolume.guardarPecas(minhasPecas.toMutableList()))
    minhasPecas = mutableListOf<Pertence>(Pertence("Versace", "Moletom"), Pertence("Farme", "Vestido"))
    println(guardaVolume.guardarPecas(minhasPecas.toMutableList()))
    guardaVolume.mostrarPecas()
    println("-----")
    guardaVolume.mostrarPecas(0)
    println("-----\nRemover")
    guardaVolume.devolverPecas(1)
    println("Removido\n-----")
    guardaVolume.mostrarPecas()
}
