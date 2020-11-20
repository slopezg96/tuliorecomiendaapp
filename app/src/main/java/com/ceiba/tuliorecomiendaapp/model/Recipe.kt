package com.ceiba.tuliorecomiendaapp.model

import com.google.gson.annotations.SerializedName

data class Recipe(val id: Int, val name: String, @SerializedName("image_url") val imageUrl: String) {
}