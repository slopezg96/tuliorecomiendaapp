package com.ceiba.tuliorecomiendaapp.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ceiba.tuliorecomiendaapp.R
import java.util.ArrayList

class DiscountsAdapter(val discounts: ArrayList<String>) :
    RecyclerView.Adapter<DiscountsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val  view: View = LayoutInflater.from(parent.context).inflate(R.layout.row_discount, parent, false)
        return ViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun getItemCount(): Int  = discounts.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

}
