package com.klossteles.desafioandroid.restaurant.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.klossteles.desafioandroid.R
import com.klossteles.desafioandroid.meal.model.MealModel
import com.klossteles.desafioandroid.meal.repository.MealRepository
import com.klossteles.desafioandroid.meal.view.MealListAdapter
import com.klossteles.desafioandroid.meal.view.MealListFragment
import com.klossteles.desafioandroid.meal.viewModel.MealListViewModel
import com.klossteles.desafioandroid.restaurant.view.RestaurantFragment.Companion.MEAL_ID

class RestaurantFragment : Fragment() {
    lateinit var minhaView: View
    lateinit var viewModel: MealListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        minhaView = inflater.inflate(R.layout.fragment_restaurant, container, false)
        return minhaView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.txtRestaurantName).text = arguments?.getString(
            RestaurantsListFragment.RESTAURANT_NAME)
        val restaurantImage = arguments?.getInt(RestaurantsListFragment.RESTAURANT_IMAGE)
        if (restaurantImage != null) {
            val imageDrawable = ContextCompat.getDrawable(view.context, restaurantImage)
            view.findViewById<ImageView>(R.id.imgRestaurant).setImageDrawable(imageDrawable)
        }
        viewModel = ViewModelProvider(this,
            MealListViewModel.ListMealViewModelFactory(MealRepository())
        ).get(MealListViewModel::class.java)

        viewModel.meals.observe(viewLifecycleOwner, Observer {
            createList(it)
        })

        viewModel.getList()

        setBackNavigation(view)
    }

    fun createList(meals: List<MealModel>) {
        val recyclerView = minhaView.findViewById<RecyclerView>(R.id.mealList)
        val manager = GridLayoutManager(context, 2)

        val customAdapter = MealListAdapter(meals) {
            val bundle = bundleOf(MEAL_ID to it.id, MEAL_NAME to it.name, MEAL_IMG_ID to it.imgId, MEAL_DESCRIPTION to it.description)
            minhaView.findNavController().navigate(R.id.action_restaurantFragment_to_mealFragment, bundle)
        }

        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = manager
            adapter = customAdapter
        }
    }

    private fun setBackNavigation(view: View) {
        view.findViewById<ImageView>(R.id.imgBackRestaurant).setOnClickListener {
            val navController = findNavController()
            navController.navigateUp()
        }
    }

    companion object {
        const val MEAL_NAME = "NAME"
        const val MEAL_IMG_ID = "IMAGE_ID"
        const val MEAL_DESCRIPTION = "DESCRIPTION"
        const val MEAL_ID = "ID"
    }

}