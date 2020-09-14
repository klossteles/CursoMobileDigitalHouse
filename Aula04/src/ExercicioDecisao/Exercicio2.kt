fun main() {
    print("Insira um número:")
    val num = readLine()!!.toInt()
    if (num % 2 == 0) {
        print("É par")
    } else {
        print("É ímpar")
    }
}
