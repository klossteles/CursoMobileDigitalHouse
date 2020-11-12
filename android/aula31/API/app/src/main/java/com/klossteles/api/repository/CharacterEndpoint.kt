package com.klossteles.api.repository

import com.klossteles.api.model.ApiResponseModel
import com.klossteles.api.model.CharacterModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterEndpoint {
    @GET("character")
    fun getCharacters(): Call<ApiResponseModel<CharacterModel>>

    @GET("character/{id}")
    fun getCharacterDetails(@Path("id") id: Int): Call<CharacterModel>

    @GET("character")
    fun getCharacterByName(@Query("name") name: Int): Call<ApiResponseModel<CharacterModel>>
}