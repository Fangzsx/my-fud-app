package com.fangzsx.my_fud_app.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.fangzsx.my_fud_app.databinding.ActivityMealBinding
import com.fangzsx.my_fud_app.models.Meal
import com.fangzsx.my_fud_app.models.MealResponse
import com.fangzsx.my_fud_app.ui.fragments.HomeFragment
import com.fangzsx.my_fud_app.viewmodels.MealViewModel

class MealActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMealBinding
    private lateinit var mealID : String
//    private lateinit var mealName : String
//    private lateinit var mealImgUrl : String

    lateinit var mealActivityVM : MealViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMealBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mealActivityVM = ViewModelProvider(this)[MealViewModel::class.java]
        //setMealDataIntoView()
        attachMealDataIntoView()

    }

    private fun attachMealDataIntoView(){
        //get id
        intent?.let {
            mealID = intent.getStringExtra(HomeFragment.MEAL_ID)!!
        }

        mealActivityVM.getMealData(mealID)
        mealActivityVM.observeMealData().observe(this, object : Observer<Meal>{
            override fun onChanged(meal: Meal?) {
                meal?.let{
                    setMealDataIntoView1(it)
                }
            }

        })
    }

    private fun setMealDataIntoView1(meal: Meal) {
        binding.apply {
            tvCategory.text = "Category: ${meal.strCategory}"
            tvLocation.text = "Location: ${meal.strArea}"
            tvInstruction.text = meal.strInstructions
            clToolbar.title = meal.strMeal
            Glide.with(this@MealActivity).load(meal.strMealThumb).into(ivMealImageDetail)
        }
    }

//    private fun setMealDataIntoView() {
//        getMealData()
//        binding.clToolbar.title = mealName
//        Glide.with(this.applicationContext).load(mealImgUrl).into(binding.ivMealImageDetail)
//
//    }

//    private fun getMealData() {
//        intent?.let{ intent ->
//
//            mealName = intent.getStringExtra(HomeFragment.MEAL_NAME)!!
//            mealImgUrl = intent.getStringExtra(HomeFragment.MEAL_IMG_URl)!!
//        }
//    }


}