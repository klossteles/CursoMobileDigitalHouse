package com.klossteles.desafioandroid.restaurant.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.klossteles.desafioandroid.R
import com.klossteles.desafioandroid.meal.view.MealListFragment

class RestaurantFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_restaurant, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.txtRestaurantName).text = arguments?.getString(
            RestaurantsListFragment.RESTAURANT_NAME)
        val restaurantImage = arguments?.getInt(RestaurantsListFragment.RESTAURANT_IMAGE)
        if (restaurantImage != null) {
            val imageDrawable = ContextCompat.getDrawable(view.context, restaurantImage)
            view.findViewById<ImageView>(R.id.imgRestaurant).setImageDrawable(imageDrawable)
            val transaction = childFragmentManager.beginTransaction()
            transaction.replace(R.id.mealListFragmentContainer, MealListFragment())
            transaction.commit()
        }
    }

}