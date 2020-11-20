package com.ceiba.tuliorecomiendaapp.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ceiba.tuliorecomiendaapp.R
import com.ceiba.tuliorecomiendaapp.model.FoodCategoryDetail
import kotlinx.android.synthetic.main.activity_city_detail.*
import java.util.ArrayList

class FoodCategoryDetailListAdapter(val context: Context, val foodCategoryList: ArrayList<FoodCategoryDetail>) :
    RecyclerView.Adapter<FoodCategoryDetailListAdapter.ViewHolder>() {

    var onItemClick: ((FoodCategoryDetail) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val  view: View = LayoutInflater.from(parent.context).inflate(R.layout.row_food_category_list, parent, false)
        return ViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun getItemCount(): Int  = foodCategoryList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvFoodCategoryName.text = "${foodCategoryList.get(position).name}"
        val restaurantAdapter = RestaurantAdapter(foodCategoryList.get(position).restaurants)
        holder.rvRestaurant.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        holder.rvRestaurant.adapter = restaurantAdapter
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvFoodCategoryName: TextView = itemView.findViewById(R.id.tvFoodCategoryName)
        val tvSeeMoreFoodCategory: TextView = itemView.findViewById(R.id.tvSeeMoreFoodCategory)
        val rvRestaurant: RecyclerView = itemView.findViewById(R.id.rvRestaurant)

        init {
            tvSeeMoreFoodCategory.setOnClickListener {
                onItemClick?.invoke(foodCategoryList[adapterPosition])
            }
        }
    }

}