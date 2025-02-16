package com.onuryasarkaraduman.data.repository

import com.onuryasarkaraduman.common.Resource
import com.onuryasarkaraduman.common.map
import com.onuryasarkaraduman.data.mapper.toModel
import com.onuryasarkaraduman.data.source.HomeApiService
import com.onuryasarkaraduman.domain.model.CategoriesRecommendedModel
import com.onuryasarkaraduman.domain.repository.HomeRepository
import com.onuryasarkaraduman.safeApiCall
import javax.inject.Inject

internal class HomeRepositoryImpl @Inject constructor(
    private val homeApi: HomeApiService,
) : HomeRepository {
    override suspend fun getBooksByCategory(subject: String): Resource<List<CategoriesRecommendedModel>> {
        return safeApiCall {
            homeApi.getBooksByCategory(subject)
        }.map {
            it.toModel()
        }
    }
}