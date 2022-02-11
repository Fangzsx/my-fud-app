package com.fangzsx.my_fud_app.api

import com.fangzsx.my_fud_app.models.MealResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface MealAPI {

    //get random meal
    @GET("random.php")
    fun getRandomMeal() : Call<MealResponse>
}