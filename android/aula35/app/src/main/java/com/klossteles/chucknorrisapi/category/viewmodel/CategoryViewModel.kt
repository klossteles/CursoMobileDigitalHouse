package com.klossteles.chucknorrisapi.category.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.klossteles.chucknorrisapi.category.repository.CategoryRepository
import kotlinx.coroutines.Dispatchers

class CategoryViewModel(private val repository: CategoryRepository)
    :ViewModel(){

    fun getCategoriesList() = liveData(Dispatchers.IO) {
        val response = repository.getCategories()

        emit(response)
    }

    class CategoryViewModelFactory(private val repository: CategoryRepository): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return CategoryViewModel(repository) as T
        }
    }
}
