package com.klossteles.chucknorrisapi.category.repository

class CategoryRepository {
    private val _client = ICategoryEndpoint.endpoint
    suspend fun getCategories() = _client.getCategories()
}