package com.fangzsx.my_fud_app.viewmodels.favorites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fangzsx.my_fud_app.models.Meal
import com.fangzsx.my_fud_app.repo.MealRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavoritesViewModel(
    val repository : MealRepository
) : ViewModel() {

    val meals = repository.allMeal

    fun addMeal(meal : Meal) = viewModelScope.launch(Dispatchers.IO) {
        repository.addMeal(meal)
    }

    fun removeMeal(meal : Meal) = viewModelScope.launch(Dispatchers.IO) {
        repository.removeMeal(meal)
    }







}