package com.ceiba.tuliorecomiendaapp.model

import com.google.gson.annotations.SerializedName

data class BlogModel(val id: Int, val title: String, @SerializedName("image_url") val imageUrl: String) {
}