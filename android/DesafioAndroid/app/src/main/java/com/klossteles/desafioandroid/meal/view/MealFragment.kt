package com.klossteles.desafioandroid.meal.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.klossteles.desafioandroid.R
import com.klossteles.desafioandroid.restaurant.view.RestaurantsListFragment

class MealFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_meal, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.txtMealName).text = arguments?.getString(
            MealListFragment.MEAL_NAME)
        val mealImage = arguments?.getInt(MealListFragment.MEAL_IMG_ID)
        if (mealImage != null) {
            val imageDrawable = ContextCompat.getDrawable(view.context, mealImage)
            view.findViewById<ImageView>(R.id.imgMeal).setImageDrawable(imageDrawable)
        }
        view.findViewById<TextView>(R.id.txtDescriptionMeal).text = arguments?.getString(MealListFragment.MEAL_DESCRIPTION)
    }
}