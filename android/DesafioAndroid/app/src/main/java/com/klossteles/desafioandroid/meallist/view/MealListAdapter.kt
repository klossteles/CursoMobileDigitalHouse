package com.klossteles.desafioandroid.meallist.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.klossteles.desafioandroid.R
import com.klossteles.desafioandroid.meal.model.MealModel

class MealListAdapter(private val dataset: List<MealModel>, private val listener: (MealModel) -> Unit):
    RecyclerView.Adapter<MealListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_meal_item, parent, false)
        return MealListViewHolder(view)
    }

    override fun onBindViewHolder(holder: MealListViewHolder, position: Int) {
        val item = dataset[position]
        holder.bind(item)
    }

    override fun getItemCount() = dataset.size

}