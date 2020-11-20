package com.ceiba.tuliorecomiendaapp.model

data class HomeModel(val recipes: ArrayList<Recipe>, val events: ArrayList<Event>, val blogs: ArrayList<BlogModel>, val countries: ArrayList<Country>) {
}