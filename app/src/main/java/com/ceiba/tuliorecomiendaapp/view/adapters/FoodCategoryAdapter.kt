package com.ceiba.tuliorecomiendaapp.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ceiba.tuliorecomiendaapp.R
import com.ceiba.tuliorecomiendaapp.model.City
import com.ceiba.tuliorecomiendaapp.model.FoodCategory
import java.util.ArrayList

class FoodCategoryAdapter(val foodCategories: ArrayList<FoodCategory>) :
    RecyclerView.Adapter<FoodCategoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val  view: View = LayoutInflater.from(parent.context).inflate(R.layout.row_food_category, parent, false)
        return ViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun getItemCount(): Int  = foodCategories.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvFoodCategory.text = "${foodCategories.get(position).name} $position"
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvFoodCategory: TextView = itemView.findViewById(R.id.tvFoodCategory)
    }

}