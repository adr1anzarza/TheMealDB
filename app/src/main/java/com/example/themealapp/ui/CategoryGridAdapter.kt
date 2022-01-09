package com.example.themealapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.themealapp.background.response.Category
import com.example.themealapp.databinding.GridCategoryItemBinding

class CategoryGridAdapter(val onClickListener: OnClickListener ) :
        ListAdapter<Category, CategoryGridAdapter.CategoryViewHolder>(DiffCallback) {

    class CategoryViewHolder(private var binding: GridCategoryItemBinding):
            RecyclerView.ViewHolder(binding.root) {
        fun bind(category: Category) {
            binding.category = category
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Category>() {
        override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
            return oldItem.idCategory == newItem.idCategory
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(GridCategoryItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val marsProperty = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(marsProperty)
        }
        holder.bind(marsProperty)
    }

    class OnClickListener(val clickListener: (category: Category) -> Unit) {
        fun onClick(category: Category) = clickListener(category)
    }
}
