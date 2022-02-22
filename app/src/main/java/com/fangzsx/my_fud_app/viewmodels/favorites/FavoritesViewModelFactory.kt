package com.fangzsx.my_fud_app.viewmodels.favorites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.fangzsx.my_fud_app.repo.MealRepository

class FavoritesViewModelFactory(
    private val repository : MealRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return FavoritesViewModel(repository) as T
    }
}