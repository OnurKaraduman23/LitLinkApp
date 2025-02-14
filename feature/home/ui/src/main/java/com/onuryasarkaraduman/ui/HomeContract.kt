package com.onuryasarkaraduman.ui

internal object HomeContract {
    data class UiState(
        val isLoading: Boolean = true,
    )

    sealed interface UiAction {
        data object OnClick: UiAction

    }

    sealed interface UiEffect {
        data class ShowError(val message: String) : UiEffect
    }

}