package com.ceiba.tuliorecomiendaapp.model

import java.util.*
import kotlin.collections.ArrayList

data class EventResponse(val success: String, val data: ArrayList<Event>) {
}