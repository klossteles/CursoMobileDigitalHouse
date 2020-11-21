package com.klossteles.chucknorrisapi.category.repository

import com.klossteles.chucknorrisapi.data.api.NetworkUtils
import retrofit2.http.GET

interface ICategoryEndpoint {
    @GET("categories")
    suspend fun getCategories(): List<String>

    companion object {
        val endpoint: ICategoryEndpoint by lazy {
            NetworkUtils.getRetrofitInstance().create(ICategoryEndpoint::class.java)
        }
    }
}