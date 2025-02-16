package com.onuryasarkaraduman.data.dto


import com.google.gson.annotations.SerializedName

data class HomeCategoriesResponse(
    @SerializedName("items")
    val items: List<Item>,
    @SerializedName("kind")
    val kind: String,
    @SerializedName("totalItems")
    val totalItems: Int
)