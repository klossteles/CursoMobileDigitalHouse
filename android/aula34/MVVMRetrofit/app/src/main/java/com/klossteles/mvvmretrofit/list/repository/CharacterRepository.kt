package com.klossteles.mvvmretrofit.list.repository


class CharacterRepository {
    val client = ICharacterEndpoint.endpoint
    suspend fun getCharacters(name: String?, page: Int) = client.getCharacters(name, page)
}
