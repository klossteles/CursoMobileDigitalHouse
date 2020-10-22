package com.klossteles.rickappgrid

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.digitalhouse.rickapp.api.Personagem
import com.squareup.picasso.Picasso

class RickGridViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val ivwPersonagem by lazy { view.findViewById(R.id.ivwPersonagem) as ImageView }
    private val txtName by lazy { view.findViewById(R.id.txtName) as TextView }

    fun bind(character: Personagem) {
        Picasso.get().load(character.imagemUrl).into(ivwPersonagem)
        txtName.text = character.nome
    }
}
