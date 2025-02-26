package com.onuryasarkaraduman.domain.model

data class BookDetailModel(
    val id: String,
    val bookTitle: String,
    val description: String,
    val vote: Float,
    val smallImageUrl: String,
    val mediumImageUrl: String,
    val largeImageUrl: String,
    val categories: List<String>,
)
