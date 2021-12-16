package com.example.randomfactsapp.data.model

import com.google.gson.annotations.SerializedName


data class YearFactModel(
    @SerializedName("date")
    val date: String,
    @SerializedName("found")
    val found: Boolean,
    @SerializedName("number")
    val number: Int,
    @SerializedName("text")
    val text: String,
    @SerializedName("type")
    val type: String
)