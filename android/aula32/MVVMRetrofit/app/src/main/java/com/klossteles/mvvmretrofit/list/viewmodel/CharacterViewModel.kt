package com.klossteles.mvvmretrofit.list.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.klossteles.mvvmretrofit.data.api.IOnResult
import com.klossteles.mvvmretrofit.data.model.ResponseModel
import com.klossteles.mvvmretrofit.list.model.CharacterModel
import com.klossteles.mvvmretrofit.list.repository.CharacterRepository

class CharacterViewModel(
    private val repository: CharacterRepository
): ViewModel() {
    var characters = MutableLiveData<List<CharacterModel>>()
    private var firstList = listOf<CharacterModel>()

    fun getList(name: String? = null) {
        repository.getList(name, object: IOnResult<ResponseModel<CharacterModel>>{
            override fun onSuccess(result: ResponseModel<CharacterModel>) {
                characters.value = result.results
            }

            override fun onFailure() {
                TODO("Not yet implemented")
            }
        })
    }

    fun search(name: String?) {
        if (firstList.isEmpty()) {
            firstList = characters.value!!
        }
        getList(name)
    }

    fun returnFirstList() {
        characters.value = firstList.toMutableList()
    }

    class CharacterViewModelFactory(private val repository: CharacterRepository): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return CharacterViewModel(repository) as T
        }
    }
}