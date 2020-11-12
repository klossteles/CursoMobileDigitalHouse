package com.klossteles.api.model

data class ApiResponseModel<T> (
    val info: PageInfoModel,
    val results: List<T>
)