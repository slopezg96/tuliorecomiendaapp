package com.ceiba.tuliorecomiendaapp.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ceiba.tuliorecomiendaapp.R
import com.ceiba.tuliorecomiendaapp.model.BlogModel
import com.ceiba.tuliorecomiendaapp.model.Event
import java.util.ArrayList

class MasterEventsAdapter(val masterEvents: ArrayList<Event>, val context: Context) :
    RecyclerView.Adapter<MasterEventsAdapter.ViewHolder>() {

    var onItemClick: ((Event) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val  view: View = LayoutInflater.from(parent.context).inflate(R.layout.row_master_event, parent, false)
        return ViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun getItemCount(): Int  = masterEvents.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(context)
            .load(masterEvents[position].imageUrl)
            .centerCrop()
            .into(holder.ivMasterEvent)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivMasterEvent: ImageView = itemView.findViewById(R.id.ivMasterEvent)

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(masterEvents[adapterPosition])
            }
        }
    }

}
