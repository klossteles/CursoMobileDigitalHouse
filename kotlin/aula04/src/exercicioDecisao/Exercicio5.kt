fun main () {
    var numRespostasPositivas = 0
    print("Telefonou para a vítima?")
    var resposta = readLine()!!
    if (resposta.equals("S", true)) {
        numRespostasPositivas += 1
    }
    print("Esteve no local do crime? ")
    resposta = readLine()!!
    if (resposta.equals("S", true)) {
        numRespostasPositivas += 1
    }
    print("Mora perto da vítima? ")
    resposta = readLine()!!
    if (resposta.equals("S", true)) {
        numRespostasPositivas += 1
    }
    print("Devia para a vítima? ")
    resposta = readLine()!!
    if (resposta.equals("S", true)) {
        numRespostasPositivas += 1
    }
    print("Trabalhou com a vítima? ")
    resposta = readLine()!!
    if (resposta.equals("S", true)) {
        numRespostasPositivas += 1
    }
    when (numRespostasPositivas) {
        2 -> print("Suspeita")
        3,4 -> print("Cúmplice")
        5 -> print("Assassino")
        else -> print("Inocente")
    }
}
