package com.klossteles.mvvmretrofit.list.viewmodel

import androidx.lifecycle.*
import com.klossteles.mvvmretrofit.list.model.CharacterModel
import com.klossteles.mvvmretrofit.list.repository.CharacterRepository
import kotlinx.coroutines.Dispatchers

class CharacterViewModel(
    private val repository: CharacterRepository
): ViewModel() {
    private var _characters: List<CharacterModel> = listOf()
    private var _previousCharacters = listOf<CharacterModel>()

    private var _totalPages: Int = 0
    private var _page: Int = 1

    fun getList(name: String? = null, page: Int = 1) = liveData(Dispatchers.IO) {
        val response = repository.getCharacters(name, page)

        _totalPages = response.info.pages
        _characters = response.results
        emit(response.results)
    }

    fun search(name: String? = null, page: Int = 1) = liveData(Dispatchers.IO) {
        if (_previousCharacters.isEmpty()) {
            _previousCharacters = _characters
        }

        val response = repository.getCharacters(name, page)
        _totalPages = response.info.pages
        _page = 1
        _characters = response.results
        emit(response.results)
    }

    fun nextPage(name: String? = null) = liveData(Dispatchers.IO) {
        _previousCharacters = _characters
        if (_page + 1 <= _totalPages) {
            _page++
            val response = repository.getCharacters(name, _page)
            emit(response.results)
        }
    }

    fun returnFirstList() = _previousCharacters.toMutableList()

    class CharacterViewModelFactory(private val repository: CharacterRepository): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return CharacterViewModel(repository) as T
        }
    }
}