package com.klossteles.chucknorrisapi.joke.repository

import com.klossteles.chucknorrisapi.data.api.NetworkUtils
import com.klossteles.chucknorrisapi.joke.model.JokeModel
import retrofit2.http.GET
import retrofit2.http.Query

interface IJokeEndpoint {
    @GET("random")
    suspend fun getJoke(@Query("category") category: String?): JokeModel

    companion object {
        val endpoint: IJokeEndpoint by lazy {
            NetworkUtils.getRetrofitInstance().create(IJokeEndpoint::class.java)
        }
    }
}