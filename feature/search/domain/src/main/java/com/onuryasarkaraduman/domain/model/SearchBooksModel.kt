package com.onuryasarkaraduman.domain.model

data class SearchBooksModel(
    val id: String,
    val bookName: String,
    val bookUrl: String,
    val category: String,
    val authors: List<String>
)