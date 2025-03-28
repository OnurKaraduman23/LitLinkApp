package com.onuryasarkaraduman.feature.search.data.repository

import com.onuryasarkaraduman.common.Resource
import com.onuryasarkaraduman.common.map
import com.onuryasarkaraduman.data.source.SearchBooksApiService
import com.onuryasarkaraduman.domain.model.SearchBooksModel
import com.onuryasarkaraduman.features.search.domain.repository.SearchBooksRepository
import com.onuryasarkaraduman.safeApiCall
import javax.inject.Inject
import com.onuryasarkaraduman.feature.search.data.mapper.toModel

internal class SearchBooksRepositoryImpl @Inject constructor(
    private val searchBooksApi: SearchBooksApiService,
) : SearchBooksRepository {
    override suspend fun getSearchBooks(query: String): Resource<List<SearchBooksModel>> {
        return safeApiCall {
            searchBooksApi.searchBooks(query = query)
        }.map { response ->
            response.toModel() // Burada response'un tipi belli olmalı
        }
    }
}