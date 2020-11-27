package com.klossteles.desafiowebservices.comic.repository

class ComicRepository() {
    private val _client = IComicEndpoint.endpoint
    suspend fun getComics(offset: Int? = 0) = _client.getComics(offset)
    suspend fun getComicById(seriesId: Int) = _client.getComicsById(seriesId)
}