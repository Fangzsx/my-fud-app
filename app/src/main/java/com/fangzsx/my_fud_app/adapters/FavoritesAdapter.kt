package com.fangzsx.my_fud_app.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fangzsx.my_fud_app.databinding.FavoriteMealItemBinding
import com.fangzsx.my_fud_app.models.Meal

class FavoritesAdapter: RecyclerView.Adapter<FavoritesAdapter.MealViewHolder>() {
    var onItemClick : ((Meal) -> Unit)? = null

    inner class MealViewHolder(var binding : FavoriteMealItemBinding) : RecyclerView.ViewHolder(binding.root)

    private val differCallback = object : DiffUtil.ItemCallback<Meal>(){
        override fun areItemsTheSame(oldItem: Meal, newItem: Meal): Boolean {
            return oldItem.idMeal == newItem.idMeal
        }

        override fun areContentsTheSame(oldItem: Meal, newItem: Meal): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(
        this,
        differCallback
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder {
        return MealViewHolder(
            FavoriteMealItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MealViewHolder, position: Int) {
        val meal = differ.currentList[position]
        holder.binding.apply {
            Glide
                .with(holder.itemView)
                .load(meal.strMealThumb)
                .into(ivFavoriteMeal)
            tvFavoriteMealName.text = meal.strMeal
        }

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(meal)
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

}