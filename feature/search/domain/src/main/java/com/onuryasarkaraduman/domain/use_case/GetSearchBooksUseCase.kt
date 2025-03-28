package com.onuryasarkaraduman.domain.use_case

import com.onuryasarkaraduman.common.Resource
import com.onuryasarkaraduman.domain.model.SearchBooksModel
import com.onuryasarkaraduman.features.search.domain.repository.SearchBooksRepository
import javax.inject.Inject

class GetSearchBooksUseCase @Inject constructor(
    private val repository: SearchBooksRepository,
) {
    suspend operator fun invoke(query: String): Resource<List<SearchBooksModel>> {
        return repository.getSearchBooks(query = query)
    }
}