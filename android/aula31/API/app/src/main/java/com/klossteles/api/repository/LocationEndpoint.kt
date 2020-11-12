package com.klossteles.api.repository

import com.klossteles.api.model.ApiResponseModel
import com.klossteles.api.model.LocationModel
import retrofit2.Call
import retrofit2.http.GET

interface LocationEndpoint {
    @GET("location")
    fun getLocations(): Call<ApiResponseModel<LocationModel>>
}