package com.example.rakutenassigment.network

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

object NumberFactFetcher {
        // unsecure website. can cause security problems
        private const val BASE_URL = "http://numbersapi.com/"

        private fun getRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
        }

        val apiService: NumberFactService = getRetrofit().create(NumberFactService::class.java)
    }
