package com.fangzsx.my_fud_app.repo

import com.fangzsx.my_fud_app.db.MealDao
import com.fangzsx.my_fud_app.models.Meal

class MealRepository(
    private val mealDao : MealDao
) {
    val allMeal = mealDao.getMeals()

    suspend fun addMeal(meal : Meal){
        mealDao.addMeal(meal)
    }

    suspend fun removeMeal(meal : Meal){
        mealDao.removeMeal(meal)
    }

}