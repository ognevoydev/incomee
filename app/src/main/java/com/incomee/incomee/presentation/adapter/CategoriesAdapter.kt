package com.incomee.incomee.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.incomee.incomee.R
import com.incomee.incomee.databinding.CategoryItemBinding
import com.incomee.incomee.domain.model.Category

internal class CategoriesAdapter(private var items: List<Category>) :
    RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {

    internal inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = CategoryItemBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.category_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.binding.categoryTitle.text = item.title;
        holder.binding.categoryIcon.setImageResource(item.image)
    }

    override fun getItemCount(): Int {
        return items.size
    }

}