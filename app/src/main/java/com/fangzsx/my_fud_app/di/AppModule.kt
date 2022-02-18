package com.fangzsx.my_fud_app.di

import android.app.Application
import androidx.room.Room
import com.fangzsx.my_fud_app.db.FavoriteMealDB
import com.fangzsx.my_fud_app.repo.MealRepository
import com.fangzsx.my_fud_app.repo.MealRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    //Database
    @Provides
    @Singleton
    fun provideDatabase(app : Application) : FavoriteMealDB{
        return Room.databaseBuilder(
            app,
            FavoriteMealDB::class.java,
            "favorites_db.db"
        )
            .build()
    }

    @Provides
    @Singleton
    fun provideRepository(db : FavoriteMealDB) : MealRepository{
        return MealRepositoryImpl(db.dao)
    }

}