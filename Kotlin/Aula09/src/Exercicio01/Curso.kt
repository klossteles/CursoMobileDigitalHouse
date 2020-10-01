package Exercicio01

class Curso(val nome: String, var responsavel: Professor) {
    val aulas get() = ArrayList<Aula>()
    val alunos get() = ArrayList<Aluno>()
}
