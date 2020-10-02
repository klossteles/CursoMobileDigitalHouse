package listaExercicios.Exercicio01

fun main() {
    val cliente1 = Cliente("Lola", "Kloss")
    val cliente2 = Cliente("Roma", "Kloss")

    val contaCliente1 = Conta(1234, cliente1)
    val contaCliente2 = Conta(4567, cliente2)

    contaCliente1.depositar(1000.00)
    contaCliente1.sacar(500.00)
    contaCliente2.depositar(100.00)
    contaCliente2.sacar(500.00)
}
