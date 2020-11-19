package com.klossteles.mvvmretrofit.list.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.klossteles.mvvmretrofit.R
import com.klossteles.mvvmretrofit.list.model.CharacterModel
import com.squareup.picasso.Picasso

class ItemViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
    private val image = view.findViewById<ImageView>(R.id.imgIcon)
    private val name = view.findViewById<TextView>(R.id.txtName)

    fun bind(characterModel: CharacterModel) {
        name.text = characterModel.name
        Picasso.get()
            .load(characterModel.image)
            .into(image)
    }
}
