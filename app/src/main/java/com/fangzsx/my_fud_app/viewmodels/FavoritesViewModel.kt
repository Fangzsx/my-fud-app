package com.fangzsx.my_fud_app.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fangzsx.my_fud_app.models.Meal
import com.fangzsx.my_fud_app.repo.MealRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel

    @Inject constructor(
    private val mealRepository : MealRepository
) : ViewModel() {

}