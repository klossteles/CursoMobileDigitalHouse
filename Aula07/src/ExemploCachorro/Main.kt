fun main () {
    var cachorro = Cachorro("Lola", "Teles")
    cachorro.cor = "Marrom"
    cachorro.anoNasc = 2013

    var cachorro2 = Cachorro("Roma", 2013)
    cachorro2.cor = "Marrom"

    println("Nome: ${cachorro.nomeCompleto} -  ${cachorro.calculaIdade()}")
    println("Nome: ${cachorro2.nomeCompleto} -  ${cachorro2.calculaIdade()}")
}
