package com.ceiba.tuliorecomiendaapp.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ceiba.tuliorecomiendaapp.R
import com.ceiba.tuliorecomiendaapp.model.City
import java.util.ArrayList

class TulioTellsYouListAdapter(val cities: ArrayList<City>) :
    RecyclerView.Adapter<TulioTellsYouListAdapter.ViewHolder>() {

    var onItemClick: ((City) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val  view: View = LayoutInflater.from(parent.context).inflate(R.layout.row_tulio_tells_you_list, parent, false)
        return ViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun getItemCount(): Int  = cities.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvTulioTellsYou.text = "${cities.get(position).name} $position"
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvTulioTellsYou: TextView = itemView.findViewById(R.id.tvTulioTellsYou)

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(cities[adapterPosition])
            }
        }
    }

}