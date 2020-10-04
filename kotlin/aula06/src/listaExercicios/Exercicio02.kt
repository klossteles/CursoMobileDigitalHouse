package listaExercicios

fun main () {
    print("Insira a primeira mensagem: ")
    val primeiraMensagem = readLine()!!
    print("Insira a segunda mensagem: ")
    val segundaMensagem = readLine()!!
    if (getMensagensIguais(primeiraMensagem, segundaMensagem)) {
        println("Mensagens são iguais")
    } else {
        println("Mensagens são diferentes")
    }
}
fun getMensagensIguais (primeiraMensagem: String, segundaMensagem: String) = primeiraMensagem.equals(segundaMensagem)
