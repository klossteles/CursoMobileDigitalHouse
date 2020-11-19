package com.klossteles.mvvmretrofit.list.viewmodel

import androidx.lifecycle.*
import com.klossteles.mvvmretrofit.list.model.CharacterModel
import com.klossteles.mvvmretrofit.list.repository.CharacterRepository
import kotlinx.coroutines.Dispatchers

class CharacterViewModel(
    private val repository: CharacterRepository
): ViewModel() {
    var characters: List<CharacterModel> = listOf()
    private var firstList = listOf<CharacterModel>()

    fun getList(name: String? = null) = liveData(Dispatchers.IO) {
        val response = repository.getCharacters(name)

        characters = response.results
        emit(response.results)
    }

    fun search(name: String? = null) = liveData(Dispatchers.IO) {
        if (firstList.isEmpty()) {
            firstList = characters
        }

        val response = repository.getCharacters(name)
        characters = response.results
        emit(response.results)
    }

    fun returnFirstList() = firstList.toMutableList()

    class CharacterViewModelFactory(private val repository: CharacterRepository): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return CharacterViewModel(repository) as T
        }
    }
}