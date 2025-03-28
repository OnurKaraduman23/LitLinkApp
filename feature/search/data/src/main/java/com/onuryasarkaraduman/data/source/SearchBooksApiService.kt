package com.onuryasarkaraduman.data.source


import com.onuryasarkaraduman.feature.search.data.dto.SearchBooksResponse
import retrofit2.http.GET
import retrofit2.http.Query

internal interface SearchBooksApiService {
    @GET("volumes")
    suspend fun searchBooks(
        @Query("q") query: String,
    ): SearchBooksResponse
}