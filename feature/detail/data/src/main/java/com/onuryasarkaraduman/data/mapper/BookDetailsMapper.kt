package com.onuryasarkaraduman.data.mapper


import com.onuryasarkaraduman.data.dto.BookDetailResponse
import com.onuryasarkaraduman.domain.model.BookDetailModel
import com.onuryasarkaraduman.common.orZero
import kotlin.collections.orEmpty

internal fun BookDetailResponse?.toModel(): BookDetailModel {
    return BookDetailModel(
        id = this?.id.orEmpty(),
        bookTitle = this?.volumeInfo?.title.orEmpty(),
        description = this?.volumeInfo?.description.orEmpty(),
        vote = this?.volumeInfo?.maturityRating?.toFloatOrNull().orZero(),
        smallImageUrl = this?.volumeInfo?.imageLinks?.small.orEmpty(),
        mediumImageUrl = this?.volumeInfo?.imageLinks?.medium.orEmpty(),
        largeImageUrl = this?.volumeInfo?.imageLinks?.large.orEmpty(),
        categories = this?.volumeInfo?.categories.orEmpty()
    )
}
