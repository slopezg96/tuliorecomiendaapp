package com.ceiba.tuliorecomiendaapp.repository

import com.ceiba.tuliorecomiendaapp.service.TulioApiService

class TulioRepository(val apiService: TulioApiService) {

    /*fun getEvents(location: String, language: String): io.reactivex.Observable<Result> {
        return apiService.search(query = "location:$location language:$language")
    }

    fun searchUsers(username: String): Observable<Result> {
        return apiService.search(query = username)
    }*/
}