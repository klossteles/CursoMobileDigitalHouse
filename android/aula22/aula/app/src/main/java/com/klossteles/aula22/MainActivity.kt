package com.klossteles.aula22

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewManager = LinearLayoutManager(this)
//        val viewManager = GridLayoutManager(this, 2)
        val recycleView = findViewById<RecyclerView>(R.id.minhaLista)
        val viewAdapter = MeuAdapter(arrayListOf(Chat("Usuário 1", "Última mensagem da conversa", "11:30"), Chat("Usuário 2", "Resumo 2", "10:30"), Chat("Usuário 3", "Resumo 3", "9:30"), Chat("Usuário 4", "Resumo 4", "8:30")))
        recycleView.apply {
            setHasFixedSize(true)

            layoutManager = viewManager
            adapter = viewAdapter
//            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.HORIZONTAL))
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }
    }
}