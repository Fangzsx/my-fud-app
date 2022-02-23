package com.fangzsx.my_fud_app.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fangzsx.my_fud_app.databinding.FilteredMealItemBinding
import com.fangzsx.my_fud_app.models.Meal

class FilteredMealAdapter : RecyclerView.Adapter<FilteredMealAdapter.MealViewHolder>() {
    private var list = ArrayList<Meal>()

    fun setList(list : ArrayList<Meal>){
        this.list = list
        notifyDataSetChanged()
    }


    inner class MealViewHolder(val binding : FilteredMealItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder {

    }

    override fun onBindViewHolder(holder: MealViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {

    }


}