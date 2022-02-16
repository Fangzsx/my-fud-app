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

class MealCategoryViewModel : ViewModel() {

    private val TAG = "MealCategoryViewModel"
    private val categorizedMealsLiveData = MutableLiveData<List<Meal>>()

    fun getMealByCategory(category : String){
        RetrofitInstance.api.getMealsByCategory(category).enqueue(object : Callback<MealResponse>{
            override fun onResponse(call: Call<MealResponse>, response: Response<MealResponse>) {
                response.body()?.let{ resultResponse ->
                    categorizedMealsLiveData.postValue(resultResponse.meals)
                }
            }

            override fun onFailure(call: Call<MealResponse>, t: Throwable) {
                Log.e(TAG,"An error occurred ${t.message}")
            }
        })
    }

    fun observeCategorizedMealsLiveData() : LiveData<List<Meal>>{
        return categorizedMealsLiveData
    }

}