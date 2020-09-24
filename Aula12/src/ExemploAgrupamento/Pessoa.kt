package ExemploAgrupamento

import ExemploAgrupamento.Estado

data class Pessoa(val nome: String, val estado: Estado) {
    override fun toString(): String {
        return "'$nome'"
    }
}
