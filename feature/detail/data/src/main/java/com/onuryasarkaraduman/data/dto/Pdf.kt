package com.onuryasarkaraduman.data.dto


import com.google.gson.annotations.SerializedName

data class Pdf(
    @SerializedName("downloadLink")
    val downloadLink: String,
    @SerializedName("isAvailable")
    val isAvailable: Boolean
)