package com.ceiba.tuliorecomiendaapp.model

import com.google.gson.annotations.SerializedName

data class Event(val id: Int, val name: String, @SerializedName("background_image_url") val backgroundImageUrl: String, @SerializedName("image_url") val imageUrl: String) {
}