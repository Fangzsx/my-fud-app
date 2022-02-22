package com.fangzsx.my_fud_app.viewmodels.meal

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fangzsx.my_fud_app.models.Meal
import com.fangzsx.my_fud_app.models.MealResponse
import com.fangzsx.my_fud_app.repo.MealRepository
import com.fangzsx.my_fud_app.retrofit.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MealViewModel(
    private val mealRepository: MealRepository
) : ViewModel() {

    private var meal : MutableLiveData<Meal> = MutableLiveData<Meal>()
    private val TAG = "MealViewModel"

    fun addMeal(meal : Meal) = viewModelScope.launch(Dispatchers.IO) {
        mealRepository.addMeal(meal)
    }

    //get data from api
    fun getMealData(id : String){
        RetrofitInstance.api.getMealData(id).enqueue(object : Callback<MealResponse>{
            override fun onResponse(call: Call<MealResponse>, response: Response<MealResponse>) {
                response.body()?.let { mealResponse ->
                    meal.value = mealResponse.meals[0]
                }
                return
            }

            override fun onFailure(call: Call<MealResponse>, t: Throwable) {
                Log.e(TAG, "An error occurred: ${t.message}")
            }

        })
    }

    fun observeMealData() : LiveData<Meal>{
        return meal
    }

}