package com.klossteles.api.model

data class CharacterModel (
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val origin: OriginModel,
    val episode: List<String>
)