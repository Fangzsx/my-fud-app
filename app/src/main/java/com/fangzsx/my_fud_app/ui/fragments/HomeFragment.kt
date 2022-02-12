package com.fangzsx.my_fud_app.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.fangzsx.my_fud_app.databinding.FragmentHomeBinding
import com.fangzsx.my_fud_app.models.Meal
import com.fangzsx.my_fud_app.viewmodels.HomeViewModel

class HomeFragment : Fragment() {
    lateinit var binding : FragmentHomeBinding
    lateinit var homeFragmentVM : HomeViewModel
    val TAG = "HomeFragment"

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


    }

    private fun observeRandomMeal() {
        homeFragmentVM.observeRandomMealLiveData().observe(viewLifecycleOwner
        ) { meal ->
            meal?.let { mealResult ->
                setImage(mealResult.strMealThumb)
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