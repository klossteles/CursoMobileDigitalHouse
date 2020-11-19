package com.klossteles.mvvmretrofit.list.repository

import com.klossteles.mvvmretrofit.data.api.IOnResult
import com.klossteles.mvvmretrofit.data.api.NetworkUtils
import com.klossteles.mvvmretrofit.data.model.ResponseModel
import com.klossteles.mvvmretrofit.list.model.CharacterModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CharacterRepository {
    val client = ICharacterEndpoint.endpoint
    suspend fun getCharacters(name: String?) = client.getCharacters(name)
}
