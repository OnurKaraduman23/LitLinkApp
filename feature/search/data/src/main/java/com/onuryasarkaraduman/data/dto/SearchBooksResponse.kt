package com.onuryasarkaraduman.feature.search.data.dto


import com.google.gson.annotations.SerializedName

data class SearchBooksResponse(
    @SerializedName("items")
    val items: List<Item>,
    @SerializedName("kind")
    val kind: String,
    @SerializedName("totalItems")
    val totalItems: Int
)