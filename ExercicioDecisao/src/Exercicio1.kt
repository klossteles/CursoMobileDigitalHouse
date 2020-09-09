fun main() {
    print("Informe o sexo: ")
    val sexo = readLine()!!
    when (sexo) {
        "F","f" -> print("Feminino")
        "M","m" -> print("Masculino")
        else -> print("Sexo inválido")
    }
}
