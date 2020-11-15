package com.klossteles.mvvmretrofit.list.repository

import com.klossteles.mvvmretrofit.data.model.ResponseModel
import com.klossteles.mvvmretrofit.list.model.CharacterModel
import retrofit2.Call
import retrofit2.http.GET

interface ICharacterEndpoint {
    @GET("character")
    fun getCharacters(): Call<ResponseModel<CharacterModel>>
}