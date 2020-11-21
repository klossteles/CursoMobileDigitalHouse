package com.klossteles.chucknorrisapi.data.model

data class ResponseModel<T> (
    val results: List<T>
)