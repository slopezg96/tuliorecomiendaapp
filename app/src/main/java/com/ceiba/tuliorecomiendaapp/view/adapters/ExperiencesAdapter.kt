package com.ceiba.tuliorecomiendaapp.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.ceiba.tuliorecomiendaapp.R
import com.ceiba.tuliorecomiendaapp.model.City
import com.ceiba.tuliorecomiendaapp.model.Experience
import kotlinx.android.synthetic.main.acitvity_cities.*
import kotlin.math.abs


class ExperiencesAdapter(
    private val mContext: Context,
    private val experiences: ArrayList<Experience>,
    private val address: String
) : PagerAdapter() {

    private var layoutInflater: LayoutInflater? = null
    private val MAX_LINES_COLLAPSED = 3
    private val INITIAL_IS_COLLAPSED = true

    private var isCollapsed = INITIAL_IS_COLLAPSED

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = LayoutInflater.from(mContext)

        val view =    layoutInflater!!.inflate(R.layout.row_experience, container, false)
        var tvMyExperience: TextView = view.findViewById(R.id.exTvMyExperience)
        var vpGallery: ViewPager2 = view.findViewById(R.id.vpImagesGallery)

        tvMyExperience.text = experiences[position].contentBody
        val images: ArrayList<String> = ArrayList()

        for (i in 1..5) {
            images.add("")
        }


        vpGallery.adapter = ExperiencesGalleryAdapter(images, vpGallery)
        vpGallery.clipToPadding = false
        vpGallery.clipChildren = false
        vpGallery.offscreenPageLimit = 3
        vpGallery.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(40))
        compositePageTransformer.addTransformer( ViewPager2.PageTransformer() { view, position ->

            val r: Float = 1 - abs(position)
            view.scaleY = 0.85f + r * 0.15f

        })
        vpGallery.setPageTransformer(compositePageTransformer)
        container.addView(view, position)
        return view
    }
    override fun getCount(): Int {
        return experiences.size
    }
    override fun isViewFromObject(view: View, obj: Any): Boolean {
        return view === obj
    }
    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val view = `object` as View
        container.removeView(view)
    }
}