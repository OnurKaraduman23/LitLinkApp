package com.onuryasarkaraduman.ui

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.onuryasarkaraduman.domain.model.SearchBooksModel

internal class SearchScreenPreviewProvider : PreviewParameterProvider<SearchBooksContract.UIState> {
    override val values: Sequence<SearchBooksContract.UIState>
        get() = sequenceOf(
            SearchBooksContract.UIState(
                isLoading = false,
                booksList = listOf(
                    SearchBooksModel(
                        id = "",
                        bookName = "Dante's Inferno",
                        bookUrl = "",
                        category = "",
                        authors = listOf("", "")
                    ),
                    SearchBooksModel(
                        id = "",
                        bookName = "Dante's Inferno",
                        bookUrl = "",
                        category = "",
                        authors = listOf("", "")
                    ),
                    SearchBooksModel(
                        id = "",
                        bookName = "Dante's Inferno",
                        bookUrl = "",
                        category = "",
                        authors = listOf("", "")
                    ),
                    SearchBooksModel(
                        id = "",
                        bookName = "Dante's Inferno",
                        bookUrl = "",
                        category = "",
                        authors = listOf("", "")
                    ),
                ),
                initialBooksList = listOf(
                    SearchBooksModel(
                        id = "",
                        bookName = "Dante's Inferno",
                        bookUrl = "",
                        category = "",
                        authors = listOf("", "")
                    ),
                    SearchBooksModel(
                        id = "",
                        bookName = "Dante's Inferno",
                        bookUrl = "",
                        category = "",
                        authors = listOf("", "")
                    ),
                    SearchBooksModel(
                        id = "",
                        bookName = "Dante's Inferno",
                        bookUrl = "",
                        category = "",
                        authors = listOf("", "")
                    ),
                    SearchBooksModel(
                        id = "",
                        bookName = "Dante's Inferno",
                        bookUrl = "",
                        category = "",
                        authors = listOf("", "")
                    ),
                ),
            ),
            SearchBooksContract.UIState(
                isLoading = true,
                booksList = emptyList(),
                initialBooksList = emptyList()
            ),
            SearchBooksContract.UIState(
                isLoading = false,
                booksList = emptyList()
            ),

            )
}