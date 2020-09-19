package Exercicio01

fun main () {
    val curso = Curso("Mobile Android", cadastrarProfessor("Felipe", "01"))
    curso.alunos.add(cadastrarAluno("Lucas", "Kloss", "1303740"))
}

fun cadastrarAluno(nome: String, sobrenome: String, registroAcademico: String): Aluno {
    return Aluno(nome, sobrenome, registroAcademico)
}

fun cadastrarProfessor(nome: String, registroDocente: String): Professor {
    return Professor(nome, registroDocente)
}
