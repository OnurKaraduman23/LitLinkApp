package com.onuryasarkaraduman.features.search.domain.repository

import com.onuryasarkaraduman.common.Resource
import com.onuryasarkaraduman.domain.model.SearchBooksModel

interface SearchBooksRepository {
    suspend fun getSearchBooks(query: String): Resource<List<SearchBooksModel>>
}