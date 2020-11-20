package com.ceiba.tuliorecomiendaapp.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ceiba.tuliorecomiendaapp.R
import com.ceiba.tuliorecomiendaapp.model.Restaurant
import java.util.ArrayList

class RestaurantAdapter(val restaurants: ArrayList<Restaurant>) :
    RecyclerView.Adapter<RestaurantAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val  view: View = LayoutInflater.from(parent.context).inflate(R.layout.row_restaurant, parent, false)
        return ViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun getItemCount(): Int  = restaurants.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvRestaurant.text = restaurants.get(position).name
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvRestaurant: TextView = itemView.findViewById(R.id.tvRestaurant)
        val ivRestaurant: ImageView = itemView.findViewById(R.id.ivRestaurant)
    }

}