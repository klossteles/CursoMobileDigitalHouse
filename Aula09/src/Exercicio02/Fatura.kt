package Exercicio02

class Fatura() {
    val itens = ArrayList<Item>()

    fun getTotalFatura(): Double {
        var total = 0.0
        itens.forEach {
            total += it.precoUnitario * it.quantidade
        }
        return total
    }

    fun adicionarItem(item: Item): Boolean {
        if (verificaSeItemNaFatura(item.numero)) {
            for (it in itens) {
                if (it.numero == item.numero) {
                    it.quantidade += item.quantidade
                    break
                }
            }
        } else {
            itens.add(item)
        }
        println("Item ${item.descricao} adicionado a fatura.")
        return true
    }

    fun verificaSeItemNaFatura(numeroItem: Int):Boolean {
        itens.forEach {
            if (it.numero == numeroItem) {
                return true
            }
        }
        return false
    }
}
