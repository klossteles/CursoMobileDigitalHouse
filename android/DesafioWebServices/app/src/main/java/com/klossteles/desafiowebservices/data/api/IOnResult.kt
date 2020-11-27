package com.klossteles.desafiowebservices.data.api

interface IOnResult<T> {
    fun onSuccess(result: T)
    fun onFailure()
}