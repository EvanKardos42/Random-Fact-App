package com.example.randomfactsapp.data

import com.example.rakutenassigment.network.NumberFactFetcher

class FactRepository {

    suspend fun get50NumberedFacts():String = NumberFactFetcher.apiService.get50Facts()

    suspend fun getYearRandomFacts(year:String) {
        NumberFactFetcher.apiService.getPhotoData(year)
    }

}