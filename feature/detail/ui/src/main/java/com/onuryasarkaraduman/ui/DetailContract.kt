package com.onuryasarkaraduman.ui

import com.onuryasarkaraduman.domain.model.BookDetailModel

internal object DetailContract {
    data class UiState(
        val isLoading: Boolean = false,
        val bookDetails: BookDetailModel? = null,
    )

    sealed interface UiAction {
        data object OnClick : UiAction
    }

    sealed interface UIEffect {
        data class ShowError(val message: String) : UIEffect
        data object NavigateOtherScreen : UIEffect
    }

}