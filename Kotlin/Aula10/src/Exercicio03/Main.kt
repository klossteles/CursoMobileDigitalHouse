package Exercicio03

fun main () {
    val alunos = ArrayList<Aluno>()
    alunos.add(Aluno("Lucas", 1))
    alunos.add(Aluno("Silvestre", 2))
    alunos.add(Aluno("Kloss", 3))
    alunos.add(Aluno("Teles", 4))

    val aluno = Aluno("Teste", 1)
    println(alunos.contains(aluno))
}
