package com.onuryasarkaraduman.domain.repository

import com.onuryasarkaraduman.common.Resource
import com.onuryasarkaraduman.domain.model.CategoriesRecommendedModel

interface HomeRepository {
    suspend fun getBooksByCategory(subject: String): Resource<List<CategoriesRecommendedModel>>
}