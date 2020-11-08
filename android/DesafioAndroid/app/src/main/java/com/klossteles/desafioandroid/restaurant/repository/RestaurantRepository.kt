package com.klossteles.desafioandroid.restaurant.repository

import com.klossteles.desafioandroid.R
import com.klossteles.desafioandroid.meal.model.MealModel
import com.klossteles.desafioandroid.restaurant.model.RestaurantModel

class RestaurantRepository() {
    var restaurants = mutableListOf<RestaurantModel>(RestaurantModel("Tony Roma's", "Av. Lavandisca, 717 - Indianópolis, São Paulo", "22:00", R.drawable.tony_romas, getMeals()),
        RestaurantModel("Aoyama - Moema", "Alameda dos Arapanés, 532 - Moema", "00:00", R.drawable.aoyama_moema, getMeals()),
        RestaurantModel("Outback - Moema", "Av. Moaci, 187, 187 - Moema, São Paulo", "00:00", R.drawable.outback_moema, getMeals()),
        RestaurantModel("Sí Señor!", "Alameda Jauaperi, 626 - Moema", "01:00", R.drawable.si_senor, getMeals()))

    fun getList(callback: (restaurants: List<RestaurantModel>) -> Unit) {
        callback.invoke(getRestaurantsList())
    }

    fun getRestaurantsList(): MutableList<RestaurantModel> {
        return restaurants
    }

    fun getMeals(): List<Int> {
        return listOf(1,2,3,4,5,6,7,8,9,10)
    }
}
