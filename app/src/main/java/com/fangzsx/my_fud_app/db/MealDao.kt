package com.fangzsx.my_fud_app.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.fangzsx.my_fud_app.models.Meal

@Dao
interface MealDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addMeal(meal : Meal)

    @Delete
    fun removeMeal(meal : Meal)

    @Query("SELECT * FROM meals")
    fun getMeals() : LiveData<List<Meal>>

    //search for meal based on name
    @Query("SELECT * FROM meals WHERE strMeal = :mealName")
    fun getMealByName(mealName : String) : Meal

    //get all meal based on category
    @Query("SELECT * FROM meals WHERE strCategory = :category")
    fun getMealsByCategory(category : String) : LiveData<List<Meal>>

}