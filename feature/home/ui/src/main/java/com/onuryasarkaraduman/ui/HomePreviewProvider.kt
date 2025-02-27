package com.onuryasarkaraduman.ui

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.onuryasarkaraduman.domain.model.CategoriesRecommendedModel

internal class HomePreviewProvider : PreviewParameterProvider<HomeContract.UiState> {
    override val values: Sequence<HomeContract.UiState>
        get() = sequenceOf(
            HomeContract.UiState(
                isLoading = false,
                userCategoryList = listOf("action", "science", "health", "epic"),
                userSelectedCategory = "health",
                recommendedList = listOf(
                    CategoriesRecommendedModel(
                        id = "AGJKljklhs",
                        bookName = "Dante's Inferno",
                        bookUrl = "http://books.google.com/books/content?id=zQsuq8rARioC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api",
                        category = "epic"
                    ),
                    CategoriesRecommendedModel(
                        id = "AGJKljklhs",
                        bookName = "Dante's Inferno",
                        bookUrl = "http://books.google.com/books/content?id=zQsuq8rARioC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api",
                        category = "epic"
                    ),
                    CategoriesRecommendedModel(
                        id = "AGJKljklhs",
                        bookName = "Dante's Inferno",
                        bookUrl = "http://books.google.com/books/content?id=zQsuq8rARioC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api",
                        category = "epic"
                    )
                )

            ),
            HomeContract.UiState(
                isLoading = true
            ),
            HomeContract.UiState(
                isLoading = false,
                recommendedList = emptyList()
            ),
        )
}