package com.fangzsx.my_fud_app.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.fangzsx.my_fud_app.models.Meal
import com.fangzsx.my_fud_app.util.MealTypeConverter

@Database(
    entities = [Meal::class],
    version = 1

)
@TypeConverters(MealTypeConverter::class)
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