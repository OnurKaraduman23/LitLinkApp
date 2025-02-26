package com.onuryasarkaraduman.feature.detail.domain.repository

import com.onuryasarkaraduman.common.Resource
import com.onuryasarkaraduman.domain.model.BookDetailModel


interface BookDetailsRepository {
    suspend fun getBookDetails(bookId: String): Resource<BookDetailModel>
}