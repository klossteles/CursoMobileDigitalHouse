package com.klossteles.mvvmretrofit.list.repository

import com.klossteles.mvvmretrofit.data.model.ResponseModel
import com.klossteles.mvvmretrofit.list.model.CharacterModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ICharacterEndpoint {
    @GET("character")
    fun getCharacters(@Query("name") name: String?): Call<ResponseModel<CharacterModel>>
}