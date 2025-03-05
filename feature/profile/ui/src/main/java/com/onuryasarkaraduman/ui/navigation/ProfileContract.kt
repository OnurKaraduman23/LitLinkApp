package com.onuryasarkaraduman.ui.navigation

internal object ProfileContract {
    data class UiState(
        val isLoading: Boolean = true,
    )

    sealed interface UiAction {
        data object OnSignOutClick : UiAction
    }

    sealed interface UiEffect {
        data object NavigateToLogin : UiEffect
    }
}