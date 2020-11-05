package com.klossteles.aula28.contador.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ContadorViewModel: ViewModel() {
    val contador = MutableLiveData<Int>().apply { value = 0 }

//    substituido pelo apply
//    init {
//        contador.value = 0
//    }

    fun incrementar() {
        contador.value = contador.value?.plus(1)
    }
}