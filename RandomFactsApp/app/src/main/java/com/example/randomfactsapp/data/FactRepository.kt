package com.example.randomfactsapp.data

import com.example.rakutenassigment.network.NumberFactFetcher
import com.example.randomfactsapp.data.model.YearFactModel

class FactRepository {
    private val fetcher = NumberFactFetcher.apiService
    suspend fun get50NumberedFacts():String? = fetcher.get50Facts()

    suspend fun getYearRandomFacts(year:String):YearFactModel? = fetcher.getYearFact(year)

}