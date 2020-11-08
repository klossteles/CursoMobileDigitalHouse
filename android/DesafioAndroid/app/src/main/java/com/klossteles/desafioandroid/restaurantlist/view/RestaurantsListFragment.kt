package com.klossteles.desafioandroid.restaurantlist.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.klossteles.desafioandroid.R
import com.klossteles.desafioandroid.restaurant.model.RestaurantModel
import com.klossteles.desafioandroid.restaurant.repository.RestaurantRepository
import com.klossteles.desafioandroid.restaurantlist.viewModel.RestaurantListViewModel

class RestaurantsListFragment : Fragment() {
    lateinit var minhaView: View
    lateinit var viewModel: RestaurantListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this,
            RestaurantListViewModel.ListTodoListViewModelFactory(RestaurantRepository())
        ).get(RestaurantListViewModel::class.java)

        viewModel.restaurants.observe(this, Observer {
            createList(it)
        })

        viewModel.getList()
    }

    fun createList(restaurants: List<RestaurantModel>) {
        val recyclerView = minhaView.findViewById<RecyclerView>(R.id.restaurantList)
        val manager = LinearLayoutManager(context)

        val customAdapter = RestaurantListAdapter(restaurants) {
            val bundle = bundleOf(RESTAURANT_NAME to it.name, RESTAURANT_IMAGE to it.imgId)
            minhaView.findNavController().navigate(R.id.action_restaurantsListFragment_to_restaurantFragment, bundle)
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
        minhaView = inflater.inflate(R.layout.fragment_restaurants_list, container, false)
        return minhaView
    }

    companion object {
        const val RESTAURANT_NAME = "NAME"
        const val RESTAURANT_IMAGE = "IMAGE"
        const val RESTAURANT_ADDRESS = "ADDRESS"
        const val RESTAURANT_CLOSE_TIME = "CLOSE_TIME"
    }

}