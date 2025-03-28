package com.onuryasarkaraduman.ui

import com.onuryasarkaraduman.domain.model.SearchBooksModel

internal object SearchContract {

    data class UIState(
        val isLoading: Boolean = false,
        val query: String = "",
        val booksList: List<SearchBooksModel> = emptyList(),
        val initialBooksList: List<SearchBooksModel> = emptyList()
    )

    sealed interface UIAction {
        data object OnBackClick : UIAction
        data class OnBookClick(val id: String) : UIAction
        data class OnQueryChange(val query: String) : UIAction

    }

    sealed interface UIEffect {
        data class NavigateDetail(val id: String) : UIEffect
        data object NavigateBack : UIEffect
    }
}