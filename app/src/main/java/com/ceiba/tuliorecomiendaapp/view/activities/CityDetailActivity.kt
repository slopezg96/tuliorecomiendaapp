package com.ceiba.tuliorecomiendaapp.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.ceiba.tuliorecomiendaapp.R
import com.ceiba.tuliorecomiendaapp.model.*
import com.ceiba.tuliorecomiendaapp.service.TulioApiService
import com.ceiba.tuliorecomiendaapp.view.adapters.*
import kotlinx.android.synthetic.main.activity_city_detail.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CityDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city_detail)
        loadFoodCategories()
        loadFoodTopRated()
        loadFoodCategoryList()
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://percepciondtest.com/tuliorecomienda/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun getCityDetail() {
        var cityId = intent.getIntExtra("countryId", 0)

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

    private fun loadFoodCategories(){
        val foodCategories: ArrayList<FoodCategory> = ArrayList()

        for (i in 1..5) {
            foodCategories.add(FoodCategory("Categoría", "" ))
        }

        rvFoodCategories.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvFoodCategories.adapter =
            FoodCategoryAdapter(
                foodCategories
            )
    }

    private fun loadFoodTopRated(){
        val foodTopRatedList: ArrayList<Food> = ArrayList()

        for (i in 1..3) {
            foodTopRatedList.add(Food("Hamburguesa $i", "", 3.5, ""))
        }

        val foodTopRatedAdapter = TopRatedAdapter(this, foodTopRatedList)
        vpTopRated.adapter = foodTopRatedAdapter
        tabLayoutTopRated.setupWithViewPager(vpTopRated, true)

    }

    private fun loadFoodCategoryList(){
        val foodCategoryDetailList: ArrayList<FoodCategoryDetail> = ArrayList()

        for (i in 1..5) {
            val restaurants: ArrayList<Restaurant> = ArrayList()
            for (i in 1..6){
                restaurants.add(Restaurant("Restaurante $i", ""))
            }

            foodCategoryDetailList.add(FoodCategoryDetail("Categoría $i", restaurants))
        }

        rvFoodCategoriesDetailList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvFoodCategoriesDetailList.adapter = FoodCategoryDetailListAdapter(this, foodCategoryDetailList)
    }
}