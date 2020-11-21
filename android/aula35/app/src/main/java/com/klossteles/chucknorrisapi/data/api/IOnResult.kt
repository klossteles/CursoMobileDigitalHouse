package com.klossteles.chucknorrisapi.data.api

interface IOnResult<T> {
    fun onSuccess(result: T)
    fun onFailure()
}