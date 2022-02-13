package com.fangzsx.my_fud_app.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fangzsx.my_fud_app.models.Meal
import com.fangzsx.my_fud_app.models.MealPopular
import com.fangzsx.my_fud_app.models.MealResponse
import com.fangzsx.my_fud_app.models.PopularMealResponse
import com.fangzsx.my_fud_app.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {

    val TAG = "HomeViewModel"
    private var randomMealLiveData = MutableLiveData<Meal>()
    private var popularMealLiveData = MutableLiveData<List<MealPopular>>()

    fun getRandomMeal(){
        RetrofitInstance.api.getRandomMeal().enqueue(object : Callback<MealResponse> {
            override fun onResponse(call: Call<MealResponse>, response: Response<MealResponse>) {
                if(response.body() != null){
                    val randomMeal = response.body()!!.meals[0]
                    randomMealLiveData.value = randomMeal

                }else{
                    return
                }

            }

            override fun onFailure(call: Call<MealResponse>, t: Throwable) {
                Log.i(TAG, "An error occur ${t.message}")
            }
        })
    }

    fun getPopularItemsByCategory(){
        RetrofitInstance.api.getPopularMealByCategory("Seafood").enqueue(object : Callback<PopularMealResponse>{
            override fun onResponse(
                call: Call<PopularMealResponse>,
                response: Response<PopularMealResponse>
            ) {
                response.body()?.let { mealResponse ->
                    popularMealLiveData.value = mealResponse.meals
                }
            }

            override fun onFailure(call: Call<PopularMealResponse>, t: Throwable) {
                Log.e(TAG, "An error occurred ${t.message}")
            }

        })
    }

    fun observeRandomMealLiveData() : LiveData<Meal> {
        return randomMealLiveData
    }

    fun observePopularMealLiveData() : LiveData<List<MealPopular>>{
        return popularMealLiveData
    }

}