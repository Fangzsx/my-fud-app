package com.fangzsx.my_fud_app.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.fangzsx.my_fud_app.models.Meal
import com.fangzsx.my_fud_app.util.Converters

@Database(
    entities = [Meal::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class FavoriteMealDB : RoomDatabase() {
    abstract val dao : MealDao


}