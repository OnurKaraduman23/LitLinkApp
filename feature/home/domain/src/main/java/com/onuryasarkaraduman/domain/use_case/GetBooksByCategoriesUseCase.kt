package com.onuryasarkaraduman.domain.use_case

import com.onuryasarkaraduman.common.Resource
import com.onuryasarkaraduman.domain.model.CategoriesRecommendedModel
import com.onuryasarkaraduman.domain.repository.HomeRepository
import javax.inject.Inject

class GetBooksByCategoriesUseCase @Inject constructor(
    private val repository: HomeRepository
) {
    suspend operator fun invoke(category: String): Resource<List<CategoriesRecommendedModel>> {
        val allSubject = "subject:$category"
        return repository.getBooksByCategory(subject = allSubject)
    }
}