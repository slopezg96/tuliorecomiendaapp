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
import com.ceiba.tuliorecomiendaapp.model.Recipe
import java.util.ArrayList

class RecipesAdapter(val recipes: ArrayList<Recipe>, val context: Context) :
    RecyclerView.Adapter<RecipesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val  view: View = LayoutInflater.from(parent.context).inflate(R.layout.row_recipe, parent, false)
        return ViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun getItemCount(): Int  = recipes.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvRecipe.text = recipes[position].name
        Glide.with(context)
            .load(recipes[position].imageUrl)
            .centerCrop()
            .into(holder.ivRecipe)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvRecipe: TextView = itemView.findViewById(R.id.tvRecipe)
        val ivRecipe: ImageView = itemView.findViewById(R.id.ivRecipe)
    }

}
