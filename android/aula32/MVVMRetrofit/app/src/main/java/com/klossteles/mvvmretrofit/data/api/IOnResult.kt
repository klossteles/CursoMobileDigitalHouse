package com.klossteles.mvvmretrofit.data.api

interface IOnResult<T> {
    fun onSuccess(result: T)
    fun onFailure()
}