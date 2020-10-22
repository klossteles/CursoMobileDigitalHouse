package com.klossteles.rickappgrid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.digitalhouse.rickapp.api.IRespostaDaApi
import com.digitalhouse.rickapp.api.Personagem
import com.digitalhouse.rickapp.api.RickApi

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RickApi.getData(this, object: IRespostaDaApi {
            override fun obtevePersonagens(personagens: List<Personagem>) {
                criarLista(personagens)
            }
        })
    }

    fun criarLista(personagens: List<Personagem>) {
        val recycleView = findViewById<RecyclerView>(R.id.lista)
        val viewManager = GridLayoutManager(this, 2)

//        var toast: Toast? = null
        val viewAdapter = RickGridAdapter(personagens) {

            val intent = Intent(this, DetalhesPersonagemActivity::class.java)
            intent.putExtra("NAME", it.nome)
            intent.putExtra("PLANETA", it.localizacao.nome)
            intent.putExtra("IMAGEM", it.imagemUrl)
            intent.putExtra("GENERO", it.genero)

            startActivity(intent)
//            toast?.cancel()
//            toast = Toast.makeText(this, it.nome, Toast.LENGTH_SHORT)
//            toast?.show()
        }

        recycleView.apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }
}