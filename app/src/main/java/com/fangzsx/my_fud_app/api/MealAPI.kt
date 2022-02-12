package com.fangzsx.my_fud_app.api

import com.fangzsx.my_fud_app.models.MealResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MealAPI {

    //get random meal
    @GET("random.php")
    fun getRandomMeal() : Call<MealResponse>

    @GET("lookup.php")
    fun getMealData(
        @Query("i")
        id : String
    ) : Call<MealResponse>
}