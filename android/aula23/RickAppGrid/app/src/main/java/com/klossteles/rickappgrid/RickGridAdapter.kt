package com.klossteles.rickappgrid

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.digitalhouse.rickapp.api.Personagem

class RickGridAdapter(private val personagens: List<Personagem>, private val listener: (Personagem) -> Unit) :
    RecyclerView.Adapter<RickGridViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RickGridViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)

        return RickGridViewHolder(view)
    }

    override fun getItemCount() = personagens.size

    override fun onBindViewHolder(holder: RickGridViewHolder, position: Int) {
        val item = personagens[position]
        holder.bind(item)
        holder.itemView.setOnClickListener { listener(item)}
    }
}