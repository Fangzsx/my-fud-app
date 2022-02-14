package com.fangzsx.my_fud_app.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fangzsx.my_fud_app.databinding.CategoryItemBinding
import com.fangzsx.my_fud_app.models.Category

class CategoryAdapter : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    private var list = ArrayList<Category>()

    fun setCategory(list : ArrayList<Category>){
        this.list = list
        notifyDataSetChanged()
    }

    inner class CategoryViewHolder(var binding : CategoryItemBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(
            CategoryItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = list[position]
        holder.binding.apply {
            tvCategory.text = category.strCategory
            Glide
                .with(holder.itemView)
                .load(category.strCategoryThumb)
                .into(ivCategory)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

}