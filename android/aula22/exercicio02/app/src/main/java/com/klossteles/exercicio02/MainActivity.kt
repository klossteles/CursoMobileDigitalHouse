package com.klossteles.exercicio02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.digitalhouse.rickapp.api.IRespostaDaApi
import com.digitalhouse.rickapp.api.Personagem
import com.digitalhouse.rickapp.api.RickApi

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewManager = GridLayoutManager(this, 2)
        val recycleView = findViewById<RecyclerView>(R.id.minhaLista)

        RickApi.getData(this, object: IRespostaDaApi {
            override fun obtevePersonagens(personagens: List<Personagem>) {
                val viewAdapter = MeuAdapter(personagens)
                recycleView.apply {
                    layoutManager = viewManager
                    adapter = viewAdapter
                }
            }
        })
    }
}