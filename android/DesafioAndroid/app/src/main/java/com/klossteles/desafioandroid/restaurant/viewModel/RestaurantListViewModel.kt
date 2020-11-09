package com.klossteles.desafioandroid.restaurant.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.klossteles.desafioandroid.restaurant.model.RestaurantModel
import com.klossteles.desafioandroid.restaurant.repository.RestaurantRepository

class RestaurantListViewModel(
    private val repository: RestaurantRepository
):ViewModel() {
    val restaurants = MutableLiveData<List<RestaurantModel>>()

    fun getList() {
        repository.getList {
            restaurants.value = it
        }
    }

    class ListRestaurantListViewModelFactory(
        private val repository: RestaurantRepository
    ): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return RestaurantListViewModel(repository) as T
        }
    }
}