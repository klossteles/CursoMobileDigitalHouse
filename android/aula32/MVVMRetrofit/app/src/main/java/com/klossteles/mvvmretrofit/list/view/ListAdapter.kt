package com.klossteles.mvvmretrofit.list.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.klossteles.mvvmretrofit.R
import com.klossteles.mvvmretrofit.list.model.CharacterModel

class ListAdapter(private var characterModels: MutableList<CharacterModel>): RecyclerView.Adapter<ItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_list_item, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = characterModels[position]

        holder.bind(item)
    }

    override fun getItemCount() = characterModels.size
}