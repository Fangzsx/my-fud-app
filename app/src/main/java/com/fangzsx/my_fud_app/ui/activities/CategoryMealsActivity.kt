package com.fangzsx.my_fud_app.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.fangzsx.my_fud_app.R
import com.fangzsx.my_fud_app.adapters.CategoryMealsAdapter
import com.fangzsx.my_fud_app.databinding.ActivityCategoryMealsBinding
import com.fangzsx.my_fud_app.ui.fragments.HomeFragment
import com.fangzsx.my_fud_app.viewmodels.MealCategoryViewModel

class CategoryMealsActivity : AppCompatActivity() {
    private lateinit var binding : ActivityCategoryMealsBinding
    private lateinit var mealCategoryVM : MealCategoryViewModel
    private lateinit var categoryMealsAdapter : CategoryMealsAdapter
    private val TAG = "CategoryMealsActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryMealsBinding.inflate(layoutInflater)
        mealCategoryVM = ViewModelProvider(this)[MealCategoryViewModel::class.java]
        categoryMealsAdapter = CategoryMealsAdapter()

        setContentView(binding.root)


        val mealClicked = intent.getStringExtra(HomeFragment.CATEGORY_MEAL)
        mealClicked?.let {
            mealCategoryVM.getMealByCategory(it)

        }
        mealCategoryVM.observeCategorizedMealsLiveData().observe(this){ list->
            categoryMealsAdapter.setMeals(list as ArrayList)
        }

        binding.rvCategoryMeals.apply {
            layoutManager = GridLayoutManager(this@CategoryMealsActivity, 2, GridLayoutManager.VERTICAL, false)
            adapter = categoryMealsAdapter

        }







    }
}