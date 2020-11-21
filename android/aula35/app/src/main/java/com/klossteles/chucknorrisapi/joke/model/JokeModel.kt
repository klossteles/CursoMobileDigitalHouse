package com.klossteles.chucknorrisapi.joke.model

import com.google.gson.annotations.SerializedName

data class JokeModel(
    val categories: List<String>,
    val created_at: String,
    @SerializedName("icon_url")
    val iconUrl: String,
    val id: String,
    val updated_at: String,
    val url: String,
    val value: String
)