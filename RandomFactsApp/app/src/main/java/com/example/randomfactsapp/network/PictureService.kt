package com.example.rakutenassigment.network

import retrofit2.http.GET




interface RandomFactService {
    @GET("")
    suspend fun getPhotoData()

}