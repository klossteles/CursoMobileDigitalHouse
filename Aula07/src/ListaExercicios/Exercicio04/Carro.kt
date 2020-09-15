package ListaExercicios.Exercicio04

class Carro(val consumo:Double) {
    var combustivelTanque: Double = 0.0

    fun andar(kilometragem:Double) {
        if (verificarSeCombustivelSuficiente(kilometragem)) {
            combustivelTanque -= kilometragem.div(consumo)
        } else {
            println("Combustível insuficiente.")
        }
    }

    private fun verificarSeCombustivelSuficiente(kilometragem: Double) = kilometragem.div(consumo).compareTo(combustivelTanque) >= 0

    fun obterGasolina(): Double {
        println("Combustível disponível: $combustivelTanque")
        return combustivelTanque
    }

    fun adicionarGasolina(quant: Double){
        println("Quant. combustível adicionado: $quant")
        combustivelTanque += quant
    }
}
