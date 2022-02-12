package com.fangzsx.my_fud_app.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.fangzsx.my_fud_app.databinding.FragmentHomeBinding
import com.fangzsx.my_fud_app.models.Meal
import com.fangzsx.my_fud_app.ui.activities.MealActivity
import com.fangzsx.my_fud_app.viewmodels.HomeViewModel

class HomeFragment : Fragment() {
    lateinit var binding : FragmentHomeBinding
    lateinit var homeFragmentVM : HomeViewModel
    lateinit var randomMealRef : Meal

    val TAG = "HomeFragment"

    companion object{
        const val MEAL_ID = "com.fangzsx.my_fud_app.ui.fragments.mealID"
        const val MEAL_NAME = "com.fangzsx.my_fud_app.ui.fragments.mealName"
        const val MEAL_IMG_URl = "com.fangzsx.my_fud_app.ui.fragments.mealImgUrl"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeFragmentVM = ViewModelProvider(this)[HomeViewModel::class.java]

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

        homeFragmentVM.getRandomMeal()
        observeRandomMeal()

        binding.ivRandomMeal.setOnClickListener {
            openMealActivity()
        }


    }

    private fun openMealActivity() {
        Intent(activity, MealActivity::class.java).also{ intent ->
            intent.putExtra(MEAL_ID, randomMealRef.idMeal)
            intent.putExtra(MEAL_NAME, randomMealRef.strMeal)
            intent.putExtra(MEAL_IMG_URl, randomMealRef.strMealThumb)
            startActivity(intent)
        }
    }

    private fun observeRandomMeal() {
        homeFragmentVM.observeRandomMealLiveData().observe(viewLifecycleOwner
        ) { meal ->
            meal?.let { mealResult ->
                setImage(mealResult.strMealThumb)
                randomMealRef = meal
            }
        }
    }

    private fun setImage(strMealThumb: String) {
        Glide
            .with(this@HomeFragment)
            .load(strMealThumb)
            .into(binding.ivRandomMeal)
    }


}