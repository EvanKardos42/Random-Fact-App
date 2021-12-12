package com.example.rakutenassigment.network

import retrofit2.Retrofit

object RandomFactFetcher {
        // unsecure website. can cause security problems
        private const val BASE_URL = "http://numbersapi.com/"

        private fun getRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .build()
        }

        val apiService  = getRetrofit().create(RandomFactService::class.java)
    }
