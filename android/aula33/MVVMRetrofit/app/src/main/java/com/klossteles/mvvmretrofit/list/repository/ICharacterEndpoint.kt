package com.klossteles.mvvmretrofit.list.repository

import com.klossteles.mvvmretrofit.data.api.NetworkUtils
import com.klossteles.mvvmretrofit.data.model.ResponseModel
import com.klossteles.mvvmretrofit.list.model.CharacterModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ICharacterEndpoint {
    @GET("character")
    suspend fun getCharacters(@Query("name") name: String?): ResponseModel<CharacterModel>

    companion object {
        val endpoint: ICharacterEndpoint by lazy {
            NetworkUtils.getRetrofitInstance().create(ICharacterEndpoint::class.java)
        }
    }
}