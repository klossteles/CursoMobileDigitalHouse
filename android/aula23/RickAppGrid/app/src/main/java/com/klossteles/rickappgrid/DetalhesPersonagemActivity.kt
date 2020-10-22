package com.klossteles.rickappgrid

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso

class DetalhesPersonagemActivity : AppCompatActivity() {
    private val txtNameDetalhes by lazy { findViewById<TextView>(R.id.txtNameDetalhes) }
    private val txtGenero by lazy { findViewById<TextView>(R.id.txtGenero) }
    private val txtPlaneta by lazy { findViewById<TextView>(R.id.txtPlaneta) }
    private val ivwPersonagemDetalhes by lazy { findViewById<ImageView>(R.id.ivwPersonagemDetalhes) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes_personagem)

        val name = intent.getStringExtra("NAME")
        txtNameDetalhes.text = name
        val genero = intent.getStringExtra("GENERO")
        txtGenero.text = genero
        val planeta = intent.getStringExtra("PLANETA")
        txtPlaneta.text = planeta
        val urlImage = intent.getStringExtra("IMAGEM")
        Picasso.get().load(urlImage).into(ivwPersonagemDetalhes)
    }
}