package com.onuryasarkaraduman.ui

import com.onuryasarkaraduman.domain.model.CategoriesRecommendedModel

internal object HomeContract {
    data class UiState(
        val isLoading: Boolean = true,
        val recommendedList: List<CategoriesRecommendedModel> = emptyList()
    )

    sealed interface UiAction {
        data object OnClick: UiAction

    }

    sealed interface UiEffect {
        data class ShowError(val message: String) : UiEffect
    }

}