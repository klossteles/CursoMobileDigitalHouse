package com.klossteles.chucknorrisapi.joke.repository

class JokeRepository {
    private val _client = IJokeEndpoint.endpoint
    suspend fun getJoke(category: String?) = _client.getJoke(category)
}