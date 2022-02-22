package com.fangzsx.my_fud_app.viewmodels.meal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.fangzsx.my_fud_app.repo.MealRepository

class MealViewModelFactory(
    private val repository: MealRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MealViewModel(repository) as T
    }
}