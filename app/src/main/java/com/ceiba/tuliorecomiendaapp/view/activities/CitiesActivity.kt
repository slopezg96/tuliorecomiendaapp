package com.ceiba.tuliorecomiendaapp.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import com.ceiba.tuliorecomiendaapp.R
import com.ceiba.tuliorecomiendaapp.model.CitiesRecommendResponseData
import com.ceiba.tuliorecomiendaapp.model.City
import com.ceiba.tuliorecomiendaapp.model.HomeResponseData
import com.ceiba.tuliorecomiendaapp.service.TulioApiService
import com.ceiba.tuliorecomiendaapp.view.adapters.*
import kotlinx.android.synthetic.main.acitvity_cities.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CitiesActivity : AppCompatActivity() {

    var cities: ArrayList<City> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acitvity_cities)
        getCities()
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://percepciondtest.com/tuliorecomienda/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun getCities() {
        var countryId = intent.getIntExtra("countryId", 0)

        val call = getRetrofit().create(TulioApiService::class.java).getCities(countryId)
        call.enqueue(object : Callback<CitiesRecommendResponseData> {
            override fun onFailure(call: Call<CitiesRecommendResponseData>, t: Throwable) {
                Log.d("TAG_TAG", "Failed :" + t.message)
            }

            override fun onResponse(call: Call<CitiesRecommendResponseData>, response: Response<CitiesRecommendResponseData>) {
                cities = response.body()?.data!!
                loadCities()
                response.body()
            }
        })
    }

    private fun loadCities(){
        val citiesAdapter = CitiesAdapter(cities, this)
        rvCities.layoutManager = GridLayoutManager(this, 2)
        rvCities.adapter = citiesAdapter


        citiesAdapter.onItemClick = { city ->

            // do something with your item
            Log.d("TAG", city.name)
            val intent = Intent(this, CityDetailActivity::class.java)
            startActivity(intent)
        }

    }
}