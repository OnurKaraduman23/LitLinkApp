package com.onuryasarkaraduman.data.repository

import com.onuryasarkaraduman.common.Resource
import com.onuryasarkaraduman.common.map
import com.onuryasarkaraduman.data.mapper.toModel
import com.onuryasarkaraduman.data.source.BookDetailsApiService
import com.onuryasarkaraduman.domain.model.BookDetailModel
import com.onuryasarkaraduman.feature.detail.domain.repository.BookDetailsRepository
import com.onuryasarkaraduman.safeApiCall
import javax.inject.Inject

internal class BookDetailsRepositoryImpl @Inject constructor(
    private val bookDetailsApi: BookDetailsApiService,
) : BookDetailsRepository {
    override suspend fun getBookDetails(bookId: String): Resource<BookDetailModel> {
        return safeApiCall {
            bookDetailsApi.getBookDetails(bookId)
        }.map {
            it.toModel()
        }
    }
}