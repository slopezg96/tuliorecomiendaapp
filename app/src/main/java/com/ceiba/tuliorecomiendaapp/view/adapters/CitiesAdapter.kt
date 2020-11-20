package com.ceiba.tuliorecomiendaapp.view.adapters

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ceiba.tuliorecomiendaapp.R
import com.ceiba.tuliorecomiendaapp.model.City
import java.util.ArrayList

class CitiesAdapter(val cities: ArrayList<City>, val context: Context) :
    RecyclerView.Adapter<CitiesAdapter.ViewHolder>() {

    var onItemClick: ((City) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val  view: View = LayoutInflater.from(parent.context).inflate(R.layout.row_city, parent, false)
        return ViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun getItemCount(): Int  = cities.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvCity.text = cities[position].name
        Glide.with(context)
            .load(cities[position].urlImage)
            .centerCrop()
            .into(holder.ivCity)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvCity: TextView = itemView.findViewById(R.id.tvCity)
        val ivCity: ImageView = itemView.findViewById(R.id.ivCity)

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(cities[adapterPosition])
            }
        }
    }

}