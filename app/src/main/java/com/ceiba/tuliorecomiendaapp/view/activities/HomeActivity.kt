package com.ceiba.tuliorecomiendaapp.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.view.get
import androidx.recyclerview.widget.LinearLayoutManager
import com.ceiba.tuliorecomiendaapp.R
import com.ceiba.tuliorecomiendaapp.model.*
import com.ceiba.tuliorecomiendaapp.service.TulioApiService
import com.ceiba.tuliorecomiendaapp.view.adapters.*
import kotlinx.android.synthetic.main.activity_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeActivity : AppCompatActivity() {

    var tulioTellsYouList: ArrayList<BlogModel> = ArrayList()
    var masterEvents: ArrayList<Event> = ArrayList()
    var recipes: ArrayList<Recipe> = ArrayList()
    var countryList: ArrayList<Country> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        registerActions()
        //loadDiscounts()
        getHome()
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://percepciondtest.com/tuliorecomienda/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun getHome() {
        val call = getRetrofit().create(TulioApiService::class.java).getHome()
        call.enqueue(object : Callback<HomeResponseData> {
            override fun onFailure(call: Call<HomeResponseData>, t: Throwable) {
                Log.d("TAG_TAG", "Failed :" + t.message)
            }

            override fun onResponse(call: Call<HomeResponseData>, response: Response<HomeResponseData>) {
                tulioTellsYouList = response.body()?.data?.blogs!!
                masterEvents = response.body()?.data?.events!!
                recipes = response.body()?.data?.recipes!!
                countryList = response.body()?.data?.countries!!
                loadCountriesSpinner()
                loadRecommendedRestaurant()
                loadMasterEvents()
                loadTulioTellsYou()
                response.body()
            }
        })
    }

    private fun registerActions(){
        cvRecomendaciones.setOnClickListener {
            var itemSelected = spCountries.selectedItem as Country
            val intent = Intent(this, CitiesActivity::class.java)
            intent.putExtra("countryId", itemSelected.id)
            startActivity(intent)
        }
    }

    /*private fun loadDiscounts(){
        val discounts: ArrayList<String> = ArrayList()

        for (i in 1..5) {
            discounts.add("Descuento # $i")
        }

        rvDiscounts.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvDiscounts.adapter =
            DiscountsAdapter(
                discounts
            )
    }*/

    private fun loadTulioTellsYou(){
        val tulioTellsYouAdapter = TulioTellsYouAdapter(tulioTellsYouList, this)
        rvTulioTellsYou.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvTulioTellsYou.adapter = tulioTellsYouAdapter


        tulioTellsYouAdapter.onItemClick = { experience ->

            val intent = Intent(this, TulioTellsYouListActivity::class.java)
            startActivity(intent)
        }
    }

    private fun loadMasterEvents(){
        rvMasters.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvMasters.adapter = MasterEventsAdapter(masterEvents, this)
    }

    private fun loadRecommendedRestaurant(){
        rvRecetas.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvRecetas.adapter = RecipesAdapter(recipes, this)
    }

    private fun loadCountriesSpinner(){
        val customDropDownAdapter = CustomDropDownAdapter(this, countryList)
        spCountries.adapter = customDropDownAdapter
    }
}