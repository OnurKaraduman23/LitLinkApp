package com.onuryasarkaraduman.ui

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.onuryasarkaraduman.domain.model.BookDetailModel

internal class DetailPreviewProvider : PreviewParameterProvider<DetailContract.UiState>{
    override val values: Sequence<DetailContract.UiState>
        get() = sequenceOf(
            DetailContract.UiState(
                isLoading = false,
                bookDetails = BookDetailModel(
                    id = "VXFcFG",
                    bookTitle =  "Dante's Inferno",
                    description = "Lorem Ipsum Dolor",
                    vote = 3.5f,
                    authors = "John Doe",
                    smallImageUrl = "http://books.google.com/books/content?id=zQsuq8rARioC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api",
                    mediumImageUrl = "http://books.google.com/books/content?id=zQsuq8rARioC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api",
                    largeImageUrl = "http://books.google.com/books/content?id=zQsuq8rARioC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api",
                    categories = listOf("Action","science-fiction")
                )
            ),
            DetailContract.UiState(
                isLoading = true
            ),
            DetailContract.UiState(
                isLoading = false,
                bookDetails = null
            )
        )
}