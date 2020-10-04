fun main() {
    print("Insira a primeira nota ")
    val primeiraNota = readLine()!!.toDouble()
    print("Insira a segunda nota ")
    val segundaNota = readLine()!!.toDouble()
    var media = (primeiraNota + segundaNota).div(2)
    if (media.equals(10.0)) {
        print("Aprovado com Distinção")
    } else if (media.compareTo(6.0) >= 0) {
        print("Aprovado")
    } else {
        print("Reprovado")
    }
}
