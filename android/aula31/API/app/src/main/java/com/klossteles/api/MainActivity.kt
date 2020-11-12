package com.klossteles.api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.klossteles.api.model.ApiResponseModel
import com.klossteles.api.model.CharacterModel
import com.klossteles.api.model.LocationModel
import com.klossteles.api.repository.CharacterEndpoint
import com.klossteles.api.repository.LocationEndpoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // fins de testes
        httpClient = NetworkUtils.getRetrofitInstace(BASE_URL)
        getCharacters()
        getLocations()
    }

    private fun getLocations() {
        var endpoint = httpClient.create(LocationEndpoint::class.java)
        endpoint.getLocations().enqueue(object : Callback<ApiResponseModel<LocationModel>> {
            override fun onResponse(
                call: Call<ApiResponseModel<LocationModel>>,
                response: Response<ApiResponseModel<LocationModel>>
            ) {
                val result = response.body()
                Toast.makeText(this@MainActivity, result!!.results[0].name, Toast.LENGTH_LONG)
                    .show()
            }

            override fun onFailure(call: Call<ApiResponseModel<LocationModel>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    private fun getCharacters() {
        var endpoint = httpClient.create(CharacterEndpoint::class.java)
        endpoint.getCharacters().enqueue(object : Callback<ApiResponseModel<CharacterModel>> {
            override fun onResponse(
                call: Call<ApiResponseModel<CharacterModel>>,
                response: Response<ApiResponseModel<CharacterModel>>
            ) {
                val result = response.body()
                Toast.makeText(this@MainActivity, result!!.results[0].name, Toast.LENGTH_LONG)
                    .show()
            }

            override fun onFailure(call: Call<ApiResponseModel<CharacterModel>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    companion object {
        const val BASE_URL = "https://rickandmortyapi.com/api/"
        lateinit var httpClient: Retrofit
    }
}