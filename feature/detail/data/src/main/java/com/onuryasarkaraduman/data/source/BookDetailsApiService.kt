package com.onuryasarkaraduman.data.source

import com.onuryasarkaraduman.core.network.BuildConfig
import com.onuryasarkaraduman.data.dto.BookDetailResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

internal interface BookDetailsApiService {
    @GET("volumes/{volumeId}")
    suspend fun getBookDetails(
        @Path("volumeId") bookId: String,
        @Query("key") apiKey: String = BuildConfig.API_KEY,
    ): BookDetailResponse
}