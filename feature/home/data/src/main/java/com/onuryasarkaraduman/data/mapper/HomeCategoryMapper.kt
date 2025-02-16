package com.onuryasarkaraduman.data.mapper

import com.onuryasarkaraduman.data.dto.HomeCategoriesResponse
import com.onuryasarkaraduman.domain.model.CategoriesRecommendedModel
import kotlin.collections.orEmpty

internal fun HomeCategoriesResponse?.toModel(): List<CategoriesRecommendedModel> {
    return this?.items?.map { item ->
        CategoriesRecommendedModel(
            id = item.id.orEmpty(),
            bookName = item.volumeInfo?.title.orEmpty(),
            bookUrl = item.volumeInfo?.imageLinks?.thumbnail.orEmpty(),
            category = item.volumeInfo?.categories?.firstOrNull().orEmpty(),
        )
    }.orEmpty()
}