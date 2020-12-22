package com.arslan.countryapp.data.remote

import com.google.gson.annotations.SerializedName

data class CountryModel(
    @SerializedName("name")
    val countryName: String,
    @SerializedName("capital")
    val countryCapital: String,
    @SerializedName("region")
    val countryRegion: String,
    @SerializedName("currency")
    val currency: String,
    @SerializedName("flag")
    val flag: String,
    @SerializedName("language")
    val language: String
)