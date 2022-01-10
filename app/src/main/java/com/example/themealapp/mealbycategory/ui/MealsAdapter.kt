package com.example.themealapp.mealbycategory.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.themealapp.databinding.GridMealItemBinding
import com.example.themealapp.mealbycategory.background.response.Meal

class MealsAdapter(val onClickListener: OnClickListener ) :
    ListAdapter<Meal, MealsAdapter.MealViewHolder>(DiffCallback) {

    class MealViewHolder(private var binding: GridMealItemBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(meal: Meal) {
            binding.meal = meal
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Meal>() {
        override fun areItemsTheSame(oldItem: Meal, newItem: Meal): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Meal, newItem: Meal): Boolean {
            return oldItem.idMeal == newItem.idMeal
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): MealViewHolder {
        return MealViewHolder(GridMealItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: MealViewHolder, position: Int) {
        val meal = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(meal)
        }
        holder.bind(meal)
    }

    class OnClickListener(val clickListener: (meal: Meal) -> Unit) {
        fun onClick(meal: Meal) = clickListener(meal)
    }
}