package listaExercicios.Exercicio5

class Concessionaria {
    var vendas = ArrayList<Venda>()

    fun registrarVenda(veiculo: Veiculo, cliente: Cliente, valor: Double) {
        vendas.add(Venda(valor, veiculo, cliente))
    }
}
