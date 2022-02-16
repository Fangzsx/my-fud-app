package com.fangzsx.my_fud_app.viewmodels

import androidx.lifecycle.ViewModel
import com.fangzsx.my_fud_app.models.MealCategoryResponse
import com.fangzsx.my_fud_app.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MealCategoryViewModel : ViewModel() {

    fun getMealByCategory(category : String){
        RetrofitInstance.api.getMealsByCategory(category).enqueue(object : Callback<MealCategoryResponse>{
            override fun onResponse(
                call: Call<MealCategoryResponse>,
                response: Response<MealCategoryResponse>
            ) {

            }

            override fun onFailure(call: Call<MealCategoryResponse>, t: Throwable) {
                
            }

        })
    }

}