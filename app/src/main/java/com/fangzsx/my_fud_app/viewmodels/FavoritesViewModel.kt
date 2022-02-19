package com.fangzsx.my_fud_app.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fangzsx.my_fud_app.models.Meal
import com.fangzsx.my_fud_app.repo.MealRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel

    @Inject constructor(
    private val mealRepository : MealRepository
) : ViewModel() {

    private var favoriteList = MutableLiveData<List<Meal>>()

    fun retrieveFavoriteList(){

    }

}