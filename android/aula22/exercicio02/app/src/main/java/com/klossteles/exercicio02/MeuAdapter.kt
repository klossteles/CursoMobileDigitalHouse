package com.klossteles.exercicio02

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.digitalhouse.rickapp.api.Personagem
import com.squareup.picasso.Picasso

class MeuAdapter(private val characters: List<Personagem>): RecyclerView.Adapter<MeuAdapter.MeuViewHolder>() {
    class MeuViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val ivwPersonagem by lazy { view.findViewById(R.id.ivwPersonagem) as ImageView }

        fun bind(character: Personagem) {
            Picasso.get().load(character.imagemUrl).into(ivwPersonagem)
        }
    }

    // Inflar o xml (a linha)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_lista, parent, false)
        return MeuViewHolder(view)
    }

    // Vai ser chamado a cada item do dataset
    override fun onBindViewHolder(holder: MeuViewHolder, position: Int) {
        holder.bind(characters[position])
    }

    // Quantidade de items do meu dataset
    override fun getItemCount() = characters.size
}