package com.klossteles.desafioandroid.meal.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.klossteles.desafioandroid.R
import com.klossteles.desafioandroid.meal.model.MealModel
import com.klossteles.desafioandroid.meal.repository.MealRepository
import com.klossteles.desafioandroid.meal.viewModel.MealListViewModel
import com.klossteles.desafioandroid.restaurant.view.RestaurantsListFragment

class MealListFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_meal_list, container, false)
    }
}