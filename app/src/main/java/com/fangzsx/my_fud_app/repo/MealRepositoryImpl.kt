package com.fangzsx.my_fud_app.repo

import androidx.lifecycle.LiveData
import com.fangzsx.my_fud_app.db.MealDao
import com.fangzsx.my_fud_app.models.Meal

class MealRepositoryImpl(
    private val dao : MealDao
) : MealRepository{
    override fun addMeal(meal: Meal) {
        dao.addMeal(meal)
    }

    override fun removeMeal(meal: Meal) {
        dao.removeMeal(meal)
    }

    override fun getMeals(): LiveData<List<Meal>> {
        return dao.getMeals()
    }

    override fun getMealByName(mealName: String): Meal {
        return dao.getMealByName(mealName)
    }

    override fun getMealsByCategory(category: String): LiveData<List<Meal>> {
        return dao.getMealsByCategory(category)
    }
}