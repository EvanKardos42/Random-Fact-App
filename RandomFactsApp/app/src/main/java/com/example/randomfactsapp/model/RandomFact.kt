package com.example.randomfactsapp.model

import com.squareup.moshi.Json

data class RandomFact(
    @Json()
    val fact:String
    )
