package exercicio04

fun main () {
    val funcionarios = ArrayList<Funcionario>()
    funcionarios.add(Funcionario("Lucas", 1))
    funcionarios.add(Funcionario("Silvestre", 2))
    funcionarios.add(Funcionario("Kloss", 3))
    funcionarios.add(Funcionario("Teles", 4))

    val funcionario = Funcionario("Teste", 1)
    println(funcionarios.contains(funcionario))
}
