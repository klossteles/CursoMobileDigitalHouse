package ExemploAgrupamento

data class Estado(val sigla: String, val nome: String) {
    override fun toString(): String {
        return "Estado ='$nome'"
    }
}
