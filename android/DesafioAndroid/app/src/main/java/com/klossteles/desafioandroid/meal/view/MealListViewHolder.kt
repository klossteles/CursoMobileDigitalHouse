package com.klossteles.desafioandroid.meal.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.klossteles.desafioandroid.R
import com.klossteles.desafioandroid.meal.model.MealModel

class MealListViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
    private val image = view.findViewById<ImageView>(R.id.imgMealList)
    private val name = view.findViewById<TextView>(R.id.txtMealNameItem)

    fun bind(meal: MealModel){
        name.text = meal.name
        image.setImageDrawable(ContextCompat.getDrawable(view.context, meal.imgId))
    }
}