package com.klossteles.desafioandroid.restaurantlist.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.klossteles.desafioandroid.R
import com.klossteles.desafioandroid.restaurant.model.RestaurantModel

class RestaurantListViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
    private val name = view.findViewById<TextView>(R.id.txtRestaurantName)
    private val address = view.findViewById<TextView>(R.id.txtRestaurantAddress)
    private val closeTime = view.findViewById<TextView>(R.id.txtRestaurantCloseTime)
    private val image = view.findViewById<ImageView>(R.id.imgRestaurant)

    fun bind(restaurant: RestaurantModel) {
        name.text = restaurant.name
        address.text = restaurant.address
        closeTime.text = view.resources.getString(R.string.close_at, restaurant.closeTime)
        image.setImageDrawable(ContextCompat.getDrawable(view.context, restaurant.imgId))
    }
}