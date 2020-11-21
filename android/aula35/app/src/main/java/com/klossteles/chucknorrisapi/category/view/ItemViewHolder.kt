package com.klossteles.chucknorrisapi.category.view

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.klossteles.chucknorrisapi.R
import java.util.*

class ItemViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
    private val category = view.findViewById<TextView>(R.id.txtCategory)

    fun bind(item: String) {
        category.text = item.capitalize(Locale.ROOT)
    }
}