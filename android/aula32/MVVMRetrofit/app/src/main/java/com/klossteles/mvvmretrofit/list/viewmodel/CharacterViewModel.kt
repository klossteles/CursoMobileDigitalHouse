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
    val characters = MutableLiveData<List<CharacterModel>>()

    fun getList() {
        repository.getList(object: IOnResult<ResponseModel<CharacterModel>>{
            override fun onSuccess(result: ResponseModel<CharacterModel>) {
                characters.value = result.results
            }

            override fun onFailure() {
                TODO("Not yet implemented")
            }
        })
    }

    class CharacterViewModelFactory(private val repository: CharacterRepository): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return CharacterViewModel(repository) as T
        }
    }
}