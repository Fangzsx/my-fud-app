package com.fangzsx.my_fud_app.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fangzsx.my_fud_app.databinding.CategorizedMealItemBinding
import com.fangzsx.my_fud_app.models.Meal

class CategoryMealsAdapter : RecyclerView.Adapter<CategoryMealsAdapter.MealViewHolder>(){
    inner class MealViewHolder(var binding : CategorizedMealItemBinding) : RecyclerView.ViewHolder(binding.root)
    var categorizedMeals = ArrayList<Meal>()

    fun setMeals(list : ArrayList<Meal>){
        this.categorizedMeals = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder {
        return MealViewHolder(
            CategorizedMealItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MealViewHolder, position: Int) {
        val meal = categorizedMeals[position]
        holder.binding.apply {
            //set image
            Glide
                .with(holder.itemView)
                .load(meal.strMealThumb)
                .into(ivCategorizedMeal)
            tvCategory.text = meal.strMeal
        }
    }

    override fun getItemCount(): Int {
        return categorizedMeals.size
    }


}