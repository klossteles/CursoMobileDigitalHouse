package ListaExercicios.Exercicio5

fun main () {
    val carro = Veiculo("Renault", "Sandero", 2015, "Branca", 39000)
    val cliente = Cliente("Lucas", "Teles", "klossteles@gmail.com")
    val concessionaria = Concessionaria()
    concessionaria.registrarVenda(carro, cliente, 290000.0)
    for (venda in concessionaria.vendas) {
        println("Venda da concessionária ")
        println("Cliente: ${venda.cliente.nome} ${venda.cliente.sobrenome}")
        println("Contato cliente: ${venda.cliente.contato}")
        println("Valor: R\$${venda.valorDaVenda}")
        println("Veiculo: ${venda.veiculoVendido.marca} - ${venda.veiculoVendido.modelo}/${venda.veiculoVendido.anoFabricacao} ${venda.veiculoVendido.cor}")
    }
}
