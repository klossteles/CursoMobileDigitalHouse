package com.klossteles.api.model

data class LocationModel (
    val id: String,
    val name: String,
    val type: String,
    val dimension: String,
    val residents: List<String>
)