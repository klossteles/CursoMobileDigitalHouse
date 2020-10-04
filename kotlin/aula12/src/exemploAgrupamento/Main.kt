package exemploAgrupamento

fun main () {
    val pessoas = mutableListOf<Pessoa>()
    pessoas.add(Pessoa("Lucas", Estado("PR", "Paraná")))
    pessoas.add(Pessoa("Silvestre", Estado("PR", "Paraná")))
    pessoas.add(Pessoa("Kloss", Estado("SC", "Santa Catarina")))
    pessoas.add(Pessoa("Teles", Estado("RS", "Rio Grando do Sul")))
    pessoas.add(Pessoa("Teste", Estado("SP", "São Paulo")))
    pessoas.add(Pessoa("Teste 2", Estado("SP", "São Paulo")))

//    val pessoasAgrupadas = mutableMapOf<String, MutableList<Pessoa>>()
//    pessoas.forEach {
//        if (!pessoasAgrupadas.containsKey(it.estado.sigla)) {
//            pessoasAgrupadas[it.estado.sigla] = mutableListOf()
//        }
//        pessoasAgrupadas[it.estado.sigla]?.add(it)
//    }
//    println(pessoasAgrupadas["PR"])
    println(pessoas.groupBy { it.estado.sigla })
}
