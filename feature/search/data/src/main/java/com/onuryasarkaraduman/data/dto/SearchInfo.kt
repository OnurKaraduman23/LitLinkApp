package com.onuryasarkaraduman.feature.search.data.dto


import com.google.gson.annotations.SerializedName

data class SearchInfo(
    @SerializedName("textSnippet")
    val textSnippet: String
)