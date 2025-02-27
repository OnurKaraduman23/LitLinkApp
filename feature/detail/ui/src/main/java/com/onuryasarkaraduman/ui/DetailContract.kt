package com.onuryasarkaraduman.ui

import com.onuryasarkaraduman.domain.model.BookDetailModel

internal object DetailContract {
    data class UiState(
        val isLoading: Boolean = false,
        val bookDetails: BookDetailModel? = null,
    )

    sealed interface UiAction {
        data object OnClick : UiAction
        data object OnBackClick: UiAction
    }

    sealed interface UiEffect {
        data class ShowError(val message: String) : UiEffect
        data object NavigateOtherScreen : UiEffect
        data object NavigateBack : UiEffect
    }

}