package com.klossteles.mvvmretrofit.data.model

data class ResponseModel<T> (
    val info: PageInfoModel,
    val results: List<T>
)