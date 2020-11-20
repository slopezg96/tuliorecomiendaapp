package com.ceiba.tuliorecomiendaapp.service

import com.ceiba.tuliorecomiendaapp.model.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface TulioApiService {
    @GET("events")
    fun getEvents():
            Call<EventResponse>

    @Headers("base-api-token: HBgmmUuVQA45OX1")
    @GET("main-screens")
    fun getHome():
            Call<HomeResponseData>

    @Headers("base-api-token: HBgmmUuVQA45OX1")
    @GET("cities/recommended")
    fun getCities(@Query("country_id") country_id: Int):
            Call<CitiesRecommendResponseData>

    @Headers("base-api-token: HBgmmUuVQA45OX1")
    @GET("food-categories/recommended")
    fun getCityDetail(@Query("city_id") cityId: Int, @Query("expanded") exapanded: String):
            Call<CitiesRecommendResponseData>

    @GET("events/{id}")
    fun getEvent(@Path("id") id: String):
            Call<Event>

}
