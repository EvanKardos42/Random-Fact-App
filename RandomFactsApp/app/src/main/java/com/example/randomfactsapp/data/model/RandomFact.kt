package com.example.randomfactsapp.data.model

import com.squareup.moshi.Json

data class RandomFact(
    @Json()
    val fact:String
    )