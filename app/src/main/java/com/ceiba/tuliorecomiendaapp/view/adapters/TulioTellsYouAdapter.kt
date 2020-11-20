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
import java.util.ArrayList

class TulioTellsYouAdapter(val blogs: ArrayList<BlogModel>, val context: Context) :
    RecyclerView.Adapter<TulioTellsYouAdapter.ViewHolder>() {

    var onItemClick: ((BlogModel) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val  view: View = LayoutInflater.from(parent.context).inflate(R.layout.row_tulio_tells_you, parent, false)
        return ViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun getItemCount(): Int  = blogs.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvTulioTellsYou.text = blogs.get(position).title
        Glide.with(context)
            .load(blogs[position].imageUrl)
            .centerCrop()
            .into(holder.ivTulioTellsYou)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTulioTellsYou: TextView = itemView.findViewById(R.id.tvTulioTellsYou)
        val ivTulioTellsYou: ImageView = itemView.findViewById(R.id.ivTulioTellsYou)

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(blogs[adapterPosition])
            }
        }
    }

}
