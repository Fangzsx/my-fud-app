package com.fangzsx.my_fud_app.repo

import androidx.lifecycle.LiveData
import com.fangzsx.my_fud_app.models.Meal

interface MealRepository {

    fun addMeal(meal : Meal)

    fun removeMeal(meal : Meal)

    fun getMeals() : LiveData<List<Meal>>

    fun getMealByName(mealName : String) : Meal

    fun getMealsByCategory(category : String) : LiveData<List<Meal>>
}