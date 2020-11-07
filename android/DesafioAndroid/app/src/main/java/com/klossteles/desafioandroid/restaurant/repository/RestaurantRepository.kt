package com.klossteles.desafioandroid.restaurant.repository

import com.klossteles.desafioandroid.R
import com.klossteles.desafioandroid.restaurant.model.RestaurantModel

class RestaurantRepository() {
    var restaurants = mutableListOf<RestaurantModel>(RestaurantModel("Tony Roma's", "Av. Lavandisca, 717 - Indianópolis, São Paulo", "22:00", R.drawable.tony_romas),
        RestaurantModel("Aoyama - Moema", "Alameda dos Arapanés, 532 - Moema", "00:00", R.drawable.aoyama_moema),
        RestaurantModel("Outback - Moema", "Av. Moaci, 187, 187 - Moema, São Paulo", "00:00", R.drawable.outback_moema),
        RestaurantModel("Sí Señor!", "Alameda Jauaperi, 626 - Moema", "01:00", R.drawable.si_senor))

    fun getList(callback: (restaurants: List<RestaurantModel>) -> Unit) {
        callback.invoke(getRestaurantsList())
    }

    fun getRestaurantsList(): MutableList<RestaurantModel> {
        return restaurants
    }
}
