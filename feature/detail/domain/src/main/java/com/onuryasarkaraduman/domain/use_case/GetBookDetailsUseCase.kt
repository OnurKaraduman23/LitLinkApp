package com.onuryasarkaraduman.domain.use_case

import com.onuryasarkaraduman.common.Resource
import com.onuryasarkaraduman.domain.model.BookDetailModel
import com.onuryasarkaraduman.feature.detail.domain.repository.BookDetailsRepository

import javax.inject.Inject


class GetBookDetailsUseCase @Inject constructor(
    private val repository: BookDetailsRepository,
) {
    suspend operator fun invoke(bookId: String): Resource<BookDetailModel> {
        return repository.getBookDetails(bookId = bookId)
    }
}