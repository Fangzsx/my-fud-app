package com.fangzsx.my_fud_app.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.fangzsx.my_fud_app.models.Meal

@Database(
    entities = [Meal::class],
    version = 1

)
abstract class MealDatabase : RoomDatabase() {

    abstract fun getMealDao() : MealDao

    //create db
    companion object{
        @Volatile
        private var INSTANCE : MealDatabase? = null

        @Synchronized
        fun getInstance(context : Context) : MealDatabase?{
            if(INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    MealDatabase::class.java,
                    "meal_db"
                )
                    .fallbackToDestructiveMigration()
                    .build()
            }


            return INSTANCE
        }
    }

}