package com.fangzsx.my_fud_app.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.fangzsx.my_fud_app.adapters.PopularMealAdapter
import com.fangzsx.my_fud_app.databinding.FragmentHomeBinding
import com.fangzsx.my_fud_app.models.Meal
import com.fangzsx.my_fud_app.models.MealPopular
import com.fangzsx.my_fud_app.ui.activities.MealActivity
import com.fangzsx.my_fud_app.viewmodels.HomeViewModel

class HomeFragment : Fragment() {
    private lateinit var binding : FragmentHomeBinding
    private lateinit var homeFragmentVM : HomeViewModel
    private lateinit var randomMealRef : Meal
    private lateinit var popularMealAdapter : PopularMealAdapter

    val TAG = "HomeFragment"

    companion object{
        const val MEAL_ID = "com.fangzsx.my_fud_app.ui.fragments.mealID"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeFragmentVM = ViewModelProvider(this)[HomeViewModel::class.java]
        popularMealAdapter = PopularMealAdapter()

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

        homeFragmentVM.getPopularItemsByCategory()
        setUpPopularMealsRecyclerView()


    }

    private fun setUpPopularMealsRecyclerView() {
        observePopularMealsByCategory()
        binding.rvPopularMeals.apply {
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            adapter = popularMealAdapter
        }

        popularMealAdapter.onItemClick = { meal->
            Intent(activity, MealActivity::class.java).apply {
                putExtra(MEAL_ID, meal.idMeal)
                startActivity(this)
            }
        }
    }

    private fun observePopularMealsByCategory() {
        homeFragmentVM.observePopularMealLiveData().observe(viewLifecycleOwner, object : Observer<List<MealPopular>>{
            override fun onChanged(list: List<MealPopular>?) {
                popularMealAdapter.setMeals(list as ArrayList<MealPopular>)
            }

        })
    }

    private fun openMealActivity() {
        Intent(activity, MealActivity::class.java).also{ intent ->
            intent.putExtra(MEAL_ID, randomMealRef.idMeal)
            startActivity(intent)
        }
    }

    private fun observeRandomMeal() {
        homeFragmentVM.observeRandomMealLiveData().observe(viewLifecycleOwner
        ) { meal ->
            meal?.let { mealResult ->
                setRandomImage(mealResult.strMealThumb)
                randomMealRef = meal
            }
        }
    }

    private fun setRandomImage(strMealThumb: String) {
        Glide
            .with(this@HomeFragment)
            .load(strMealThumb)
            .into(binding.ivRandomMeal)
    }


}