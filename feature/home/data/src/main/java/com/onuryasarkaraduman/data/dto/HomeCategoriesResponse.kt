package com.onuryasarkaraduman.data.dto


import com.google.gson.annotations.SerializedName
import com.onuryasarkaraduman.dto.Item

data class HomeCategoriesResponse(
    @SerializedName("items")
    val items: List<Item>,
    @SerializedName("kind")
    val kind: String,
    @SerializedName("totalItems")
    val totalItems: Int
)