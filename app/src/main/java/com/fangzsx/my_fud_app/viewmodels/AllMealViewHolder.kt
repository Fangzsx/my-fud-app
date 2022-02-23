package com.fangzsx.my_fud_app.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fangzsx.my_fud_app.models.Meal
import com.fangzsx.my_fud_app.models.MealResponse
import com.fangzsx.my_fud_app.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AllMealViewHolder : ViewModel() {

    private var filteredMealListLiveData = MutableLiveData<List<Meal>>()
    private val TAG = "AllMealViewHolder"

    fun getMealByFirstLetter(char : Char){
        RetrofitInstance.api.getMealByFirstLetter(char).enqueue(object : Callback<MealResponse>{
            override fun onResponse(call: Call<MealResponse>, response: Response<MealResponse>) {
                response.body()?.let { mealList ->
                    filteredMealListLiveData.postValue(mealList.meals)
                }
            }

            override fun onFailure(call: Call<MealResponse>, t: Throwable) {
                Log.e(TAG, "An error occured ${t.message}")
            }

        })
    }

    fun observeFilteredMealListLiveData() : LiveData<List<Meal>> {
        return filteredMealListLiveData
    }
}