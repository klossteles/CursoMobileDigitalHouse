package com.klossteles.desafioandroid.meallist.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.klossteles.desafioandroid.meal.model.MealModel
import com.klossteles.desafioandroid.meal.repository.MealRepository

class MealListViewModel(
    private val repository: MealRepository
    ): ViewModel() {
    val meals = MutableLiveData<List<MealModel>>()

    fun getList() {
        repository.getList {
            meals.value = it
        }
    }

    class ListMealViewModelFactory(
        private val repository: MealRepository
    ): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return MealListViewModel(repository) as T
        }
    }
}