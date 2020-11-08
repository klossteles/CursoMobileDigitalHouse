package com.klossteles.desafioandroid.restaurant.model

data class RestaurantModel(val name: String, val address: String, val closeTime: String, val imgId: Int, val mealsIds: List<Int>)