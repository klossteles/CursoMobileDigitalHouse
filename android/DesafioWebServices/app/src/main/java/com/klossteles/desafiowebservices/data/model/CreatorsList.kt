package com.klossteles.desafiowebservices.data.model

data class CreatorsList(
    val available: Int,
    val returned: Int,
    val collectionURI: String,
    val items: List<CreatorSummary>
)