package com.ceiba.tuliorecomiendaapp.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.ceiba.tuliorecomiendaapp.R
import com.ceiba.tuliorecomiendaapp.model.Food

class TopRatedAdapter (private val mContext: Context, private val itemList: ArrayList<Food>) : PagerAdapter() {

    private var layoutInflater: LayoutInflater? = null

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = LayoutInflater.from(mContext)

        val view =    layoutInflater!!.inflate(R.layout.row_top_rated, container, false)
        var tvFoodTopRated: TextView = view.findViewById(R.id.tvFoodTopRated)
        var ratingBar: RatingBar = view.findViewById(R.id.rbFoodTopRated)

        tvFoodTopRated.text = itemList[position].name
        ratingBar.rating = itemList[position].rated.toFloat()
        container.addView(view, position)
        return view
    }
    override fun getCount(): Int {
        return itemList.size
    }
    override fun isViewFromObject(view: View, obj: Any): Boolean {
        return view === obj
    }
    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val view = `object` as View
        container.removeView(view)
    }
}