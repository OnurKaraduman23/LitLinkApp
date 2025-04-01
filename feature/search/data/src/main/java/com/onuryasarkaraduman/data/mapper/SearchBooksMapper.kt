package com.onuryasarkaraduman.feature.search.data.mapper


import com.onuryasarkaraduman.domain.model.SearchBooksModel
import com.onuryasarkaraduman.feature.search.data.dto.SearchBooksResponse

internal fun SearchBooksResponse?.toModel(): List<SearchBooksModel> {
    return this?.items?.map { item ->
        SearchBooksModel(
            id = item.id.orEmpty(),
            bookName = item.volumeInfo.title.orEmpty(),
            bookUrl = item.volumeInfo.imageLinks?.thumbnail.orEmpty(),
            category = item.volumeInfo.categories?.firstOrNull().orEmpty(),
            authors = item.volumeInfo.authors.orEmpty()
        )
    }.orEmpty()
}