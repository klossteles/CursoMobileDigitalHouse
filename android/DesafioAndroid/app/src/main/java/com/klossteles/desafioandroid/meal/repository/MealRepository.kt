package com.klossteles.desafioandroid.meal.repository

import com.klossteles.desafioandroid.R
import com.klossteles.desafioandroid.meal.model.MealModel

class MealRepository {
    var meals = mutableListOf<MealModel>(MealModel(1,"Salada com molho Gengibre", "Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis.", R.drawable.meal),
        MealModel(2,"Salada com molho Gengibre", "Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis.", R.drawable.meal),
        MealModel(3,"Salada com molho Gengibre", "Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis.", R.drawable.meal),
        MealModel(4,"Salada com molho Gengibre", "Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis.", R.drawable.meal),
        MealModel(5,"Salada com molho Gengibre", "Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis.", R.drawable.meal),
        MealModel(6,"Salada com molho Gengibre", "Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis.", R.drawable.meal),
        MealModel(7,"Salada com molho Gengibre", "Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis.", R.drawable.meal),
        MealModel(8,"Salada com molho Gengibre", "Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis.", R.drawable.meal),
        MealModel(9,"Salada com molho Gengibre", "Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis.", R.drawable.meal),
        MealModel(10,"Salada com molho Gengibre", "Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis.", R.drawable.meal))

    fun getList(callback: (restaurants: List<MealModel>) -> Unit) {
        callback.invoke(getMealsList())
    }

    fun getMealsList(): MutableList<MealModel> {
        return meals
    }

}