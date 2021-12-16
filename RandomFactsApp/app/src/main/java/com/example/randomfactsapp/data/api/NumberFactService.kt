package com.example.rakutenassigment.network

import com.example.randomfactsapp.data.model.YearFactModel
import retrofit2.http.GET
import retrofit2.http.Path


interface NumberFactService {
    @GET("/1..50")
    suspend fun get50Facts():String?

    @GET("{year}/year?json")
    suspend fun getYearFact(@Path("year") year: String): YearFactModel?


}