package com.fangzsx.my_fud_app.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.fangzsx.my_fud_app.models.Meal

@Database(
    entities = [Meal::class],
    version = 1
)
abstract class FavoriteMealDB : RoomDatabase() {
    abstract val dao : MealDao

}