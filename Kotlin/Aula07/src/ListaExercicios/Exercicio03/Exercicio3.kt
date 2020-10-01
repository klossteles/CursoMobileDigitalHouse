package ListaExercicios.Exercicio03

fun main() {
    var atleta1 = Atleta("Neymar",91, 81)
    var atleta2 = Atleta("Walter", 80, 60)
    var provasAtleta1 = arrayListOf<Prova>()
    provasAtleta1.add(Prova(70, 50))
    provasAtleta1.add(Prova(82, 20))
    provasAtleta1.add(Prova(90, 50))
    var provasAtleta2 = arrayListOf<Prova>()
    provasAtleta2.add(Prova(70, 50))
    provasAtleta2.add(Prova(82, 20))
    provasAtleta2.add(Prova(79, 10))

    for (prova in provasAtleta1) {
        prova.realizarProva(atleta1)
    }

    for (prova in provasAtleta2) {
        prova.realizarProva(atleta2)
    }
}
