package com.klossteles.desafiowebservices.data.model

import com.example.marvelapp.data.model.CharacterSummary

data class CharactersList (
    val available: Int,
    val returned: Int,
    val collectionURI: String,
    val items: List<CharacterSummary>
)