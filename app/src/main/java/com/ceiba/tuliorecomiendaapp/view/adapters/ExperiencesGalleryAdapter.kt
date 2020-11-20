package com.ceiba.tuliorecomiendaapp.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.ceiba.tuliorecomiendaapp.R
import com.ceiba.tuliorecomiendaapp.model.City
import com.makeramen.roundedimageview.RoundedImageView
import java.util.ArrayList

class ExperiencesGalleryAdapter(val images: ArrayList<String>, val viewPager2: ViewPager2) :
    RecyclerView.Adapter<ExperiencesGalleryAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val  view: View = LayoutInflater.from(parent.context).inflate(R.layout.row_experience_image_gallery, parent, false)
        return ViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun getItemCount(): Int  = images.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //holder.ivGallery.
        holder.ivGallery.setImageResource(R.drawable.recetas)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val ivGallery: RoundedImageView = itemView.findViewById(R.id.ivGalleryExperience)

    }

}