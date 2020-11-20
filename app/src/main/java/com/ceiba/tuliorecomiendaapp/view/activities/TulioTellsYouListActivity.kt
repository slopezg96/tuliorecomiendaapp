package com.ceiba.tuliorecomiendaapp.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ceiba.tuliorecomiendaapp.R
import com.ceiba.tuliorecomiendaapp.model.City
import com.ceiba.tuliorecomiendaapp.view.adapters.*
import kotlinx.android.synthetic.main.acitvity_cities.*
import kotlinx.android.synthetic.main.activity_tulio_tells_you_list.*

class TulioTellsYouListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tulio_tells_you_list)
        loadTulioTellsYou()
    }

    private fun loadTulioTellsYou(){
        val cities: ArrayList<City> = ArrayList()

        for (i in 1..12) {
            cities.add(City(1, "Medellín", ""))
        }


        val tulioTellsYouLisAdapter = TulioTellsYouListAdapter(cities)
        rvTulioTellsYou.layoutManager = LinearLayoutManager(this)
        rvTulioTellsYou.adapter = tulioTellsYouLisAdapter


        tulioTellsYouLisAdapter.onItemClick = { city ->

            // do something with your item
            Log.d("TAG", city.name)
            val intent = Intent(this, CityDetailActivity::class.java)
            startActivity(intent)
        }

    }
}