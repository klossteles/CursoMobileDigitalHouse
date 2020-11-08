package com.klossteles.desafioandroid.meallist.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.klossteles.desafioandroid.R
import com.klossteles.desafioandroid.meal.model.MealModel
import com.klossteles.desafioandroid.meal.repository.MealRepository
import com.klossteles.desafioandroid.meallist.viewModel.MealListViewModel

class MealListFragment : Fragment() {
    lateinit var minhaView: View
    lateinit var viewModel: MealListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this,
            MealListViewModel.ListMealViewModelFactory(MealRepository())
        ).get(MealListViewModel::class.java)

        viewModel.meals.observe(this, Observer {
            createList(it)
        })

        viewModel.getList()
    }

    fun createList(meals: List<MealModel>) {
        val recyclerView = minhaView.findViewById<RecyclerView>(R.id.mealList)
        val manager = GridLayoutManager(context, 2)

        val customAdapter = MealListAdapter(meals) {

        }

        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = manager
            adapter = customAdapter
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        minhaView = inflater.inflate(R.layout.fragment_meal_list, container, false)
        return minhaView
    }
}