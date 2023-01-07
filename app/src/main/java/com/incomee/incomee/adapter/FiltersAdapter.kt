package com.incomee.incomee.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.incomee.incomee.R

internal class FiltersAdapter() :
    RecyclerView.Adapter<FiltersAdapter.ViewHolder>() {

    private val itemsList = arrayOf("Тип операции", "Счет", "Период")

    internal inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var itemButton: Button = view.findViewById(R.id.itemButton)

        init {
            view.setOnClickListener {
                //TODO
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemsList[position]
        holder.itemButton.text = item
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }

}