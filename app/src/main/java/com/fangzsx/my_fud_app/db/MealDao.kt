package com.fangzsx.my_fud_app.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.fangzsx.my_fud_app.models.Meal

@Dao
interface MealDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addMeal(meal : Meal)

    @Delete
    suspend fun removeMeal(meal : Meal)

    @Query("SELECT * FROM meals")
    fun getMeals() : LiveData<List<Meal>>
}