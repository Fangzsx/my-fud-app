package com.fangzsx.my_fud_app.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.fangzsx.my_fud_app.R
import com.fangzsx.my_fud_app.databinding.ActivityMealBinding
import com.fangzsx.my_fud_app.models.Meal
import com.fangzsx.my_fud_app.ui.fragments.HomeFragment

class MealActivity : AppCompatActivity() {
    lateinit var binding : ActivityMealBinding
    lateinit var mealID : String
    lateinit var mealName : String
    lateinit var mealImgUrl : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMealBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setMealDataIntoView()

    }

    private fun setMealDataIntoView() {
        getMealData()
        binding.clToolbar.title = mealName
        Glide.with(this.applicationContext).load(mealImgUrl).into(binding.ivMealImageDetail)

    }

    private fun getMealData() {
        intent?.let{ intent ->
            mealID = intent.getStringExtra(HomeFragment.MEAL_ID)!!
            mealName = intent.getStringExtra(HomeFragment.MEAL_NAME)!!
            mealImgUrl = intent.getStringExtra(HomeFragment.MEAL_IMG_URl)!!
        }
    }


}