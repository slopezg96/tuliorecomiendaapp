package com.ceiba.tuliorecomiendaapp.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.ceiba.tuliorecomiendaapp.R
import com.ceiba.tuliorecomiendaapp.model.Event
import com.ceiba.tuliorecomiendaapp.model.EventResponse
import com.ceiba.tuliorecomiendaapp.model.Experience
import com.ceiba.tuliorecomiendaapp.service.TulioApiService
import com.ceiba.tuliorecomiendaapp.view.adapters.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlinx.android.synthetic.main.activity_restaurant_detail.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory.*


class RestaurantDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_detail)
        loadExperiences()
        getEvents()

    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://percepciondtest.com/tuliorecomienda/api/")
            .addConverterFactory(create())
            .build()
    }

    private fun getEvents() {
        val call = getRetrofit().create(TulioApiService::class.java).getEvents()
        call.enqueue(object : Callback<EventResponse> {
            override fun onFailure(call: Call<EventResponse>, t: Throwable) {
                Log.d("TAG_TAG", "Failed :" + t.message)
            }

            override fun onResponse(call: Call<EventResponse>, response: Response<EventResponse>) {
                response.body()
            }
        })

        /*doAsync {
            val call = getRetrofit().create(TulioApiService::class.java).getEvents().execute()
            val puppies = call.body() as EventResponse
            uiThread {
                if(puppies.success == "true") {

                }else{

                }
            }
        }*/
    }

    private fun loadExperiences(){
        val experiences: ArrayList<Experience> = ArrayList()

        for (i in 1..3) {
            experiences.add(Experience("Hamburguesa $i", "", 3.5, "", "Expandable Text View is an android library that allows the users to create the text view which can expand and collapse to read the text description. I bet you guys have seen this in a lot of android applications but might not know the name and its purpose. Well, below is a screenshot of the Instagram application on the Play store. This feature saves a lot of space, rather than laying out the huge chunks of information and occupying the entire page we can further use this option and can utilize the space"))
        }

        val experiencesAdapter = ExperiencesAdapter(this, experiences, "")
        vpExperiences.adapter = experiencesAdapter

    }

}