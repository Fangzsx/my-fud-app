package com.fangzsx.my_fud_app.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.fangzsx.my_fud_app.R
import com.fangzsx.my_fud_app.databinding.FragmentHomeBinding
import com.fangzsx.my_fud_app.models.MealResponse
import com.fangzsx.my_fud_app.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    val TAG = "HomeFragment"
    lateinit var binding : FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        RetrofitInstance.api.getRandomMeal().enqueue(object : Callback<MealResponse>{
            override fun onResponse(call: Call<MealResponse>, response: Response<MealResponse>) {
                if(response.body() != null){
                    val randomMeal = response.body()!!.meals[0]
                    Log.i(TAG, "Meal Generated ID: ${randomMeal.idMeal} NAME: ${randomMeal.strMeal}")
                    Glide
                        .with(this@HomeFragment)
                        .load(randomMeal.strMealThumb)
                        .into(binding.ivRandomMeal)
                }else{
                    return
                }

            }

            override fun onFailure(call: Call<MealResponse>, t: Throwable) {
                Log.i(TAG, "An error occur ${t.message}")
            }

        })
    }
}