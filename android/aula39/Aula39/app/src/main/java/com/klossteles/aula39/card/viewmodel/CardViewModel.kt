package com.klossteles.aula39.card.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.klossteles.aula39.card.entity.CardEntity
import com.klossteles.aula39.card.repository.CardRepository
import kotlinx.coroutines.Dispatchers

class CardViewModel(private val repository: CardRepository): ViewModel() {
    fun addCard(card: CardEntity) = liveData(Dispatchers.IO) {
        repository.addCard(card)
        emit(true)
    }

    fun getCount() = liveData(Dispatchers.IO) {
        val count = repository.getCount()
        emit(count)
    }

    class CardViewModelFactory(private val _repository: CardRepository):
            ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return CardViewModel(_repository) as T
        }
    }
}