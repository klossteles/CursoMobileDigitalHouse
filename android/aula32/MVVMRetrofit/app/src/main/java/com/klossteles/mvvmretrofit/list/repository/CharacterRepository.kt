package com.klossteles.mvvmretrofit.list.repository

import com.klossteles.mvvmretrofit.data.api.IOnResult
import com.klossteles.mvvmretrofit.data.api.NetworkUtils
import com.klossteles.mvvmretrofit.data.model.ResponseModel
import com.klossteles.mvvmretrofit.list.model.CharacterModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CharacterRepository {
    fun getList(name: String?, onResult: IOnResult<ResponseModel<CharacterModel>>) {
        val client = NetworkUtils.getRetrofitInstance()
        val api = client.create(ICharacterEndpoint::class.java)

        api.getCharacters(name).enqueue(object: Callback<ResponseModel<CharacterModel>> {
            override fun onResponse(
                call: Call<ResponseModel<CharacterModel>>,
                response: Response<ResponseModel<CharacterModel>>
            ) {
                onResult.onSuccess(response.body()!!)
            }

            override fun onFailure(call: Call<ResponseModel<CharacterModel>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}
