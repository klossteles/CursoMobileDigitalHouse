package com.klossteles.desafioandroid.restaurantlist.view

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.klossteles.desafioandroid.R
import com.klossteles.desafioandroid.restaurantlist.model.RestaurantModel

class RestaurantListViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
    private val name = view.findViewById<TextView>(R.id.txtRestaurantName)
    private val address = view.findViewById<TextView>(R.id.txtRestaurantAddress)
    private val closeTime = view.findViewById<TextView>(R.id.txtRestaurantCloseTime)

    fun bind(restaurantModel: RestaurantModel) {
        name.text = restaurantModel.name
        address.text = restaurantModel.address
        closeTime.text = restaurantModel.closeTime.toString()
    }
}