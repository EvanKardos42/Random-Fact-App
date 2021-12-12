package com.example.randomfactsapp.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RandomFactYearModel(
    @Json(name = "date")
    val date: String,
    @Json(name = "found")
    val found: Boolean,
    @Json(name = "number")
    val number: Int,
    @Json(name = "text")
    val text: String,
    @Json(name = "type")
    val type: String
)