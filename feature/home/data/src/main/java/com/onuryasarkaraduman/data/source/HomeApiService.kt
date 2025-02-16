package com.onuryasarkaraduman.data.source

import com.onuryasarkaraduman.core.network.BuildConfig
import com.onuryasarkaraduman.data.dto.HomeCategoriesResponse
import retrofit2.http.GET
import retrofit2.http.Query

internal interface HomeApiService {
    @GET("volumes")
    suspend fun getBooksByCategory(
        @Query("q") subject: String,
        @Query("key") apiKey: String = BuildConfig.API_KEY
    ): HomeCategoriesResponse
}