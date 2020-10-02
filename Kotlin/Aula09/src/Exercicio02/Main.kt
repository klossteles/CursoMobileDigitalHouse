package exercicio02

fun main () {
    var fatura = Fatura()
    var item1 = Item(1, "Headset", 1, -1.0)
    var item2 = Item(2, "Monitor", -1, 1.0)
    fatura.adicionarItem(item1)
    fatura.adicionarItem(item2)
    println("Total da fatura: R\$${"%.2f".format(fatura.getTotalFatura())}")

    item1 = Item(1, "Headset", 1, 300.0)
    item2 = Item(2, "Monitor", 2, 1500.0)
    var item3 = Item(3, "teclado", 1, 200.0)

    fatura = Fatura()
    fatura.adicionarItem(item1)
    fatura.adicionarItem(item2)
    fatura.adicionarItem(item3)
    fatura.adicionarItem(item1)
    println("Total da fatura: R\$${"%.2f".format(fatura.getTotalFatura())}")


}
