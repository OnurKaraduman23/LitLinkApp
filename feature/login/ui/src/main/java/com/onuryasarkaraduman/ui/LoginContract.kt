package com.onuryasarkaraduman.ui

internal object LoginContract {
    data class UiState(
        val isLoading: Boolean = false,
        val email: String = "",
        val password: String = "",
    )

    sealed interface UiAction {
        data object OnBackClick : UiAction
        data class OnEmailChange(val email: String) : UiAction
        data class OnPasswordChange(val password: String) : UiAction
        data object OnLoginClick : UiAction
        data object OnRegisterClick : UiAction
        data object OnForgotPasswordClick : UiAction
    }

    sealed interface UiEffect {
        data object NavigateBack : UiEffect
        data object NavigateRegister : UiEffect
        data object NavigateHome : UiEffect
    }
}