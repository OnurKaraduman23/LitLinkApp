package com.onuryasarkaraduman.ui.categories_selector

internal object CategoriesContract {

    data class UiState(
        val isLoading: Boolean = false,
    )

    sealed interface UiAction {
        data class SaveCategories(val selectedStatesList: List<Boolean>) : UiAction
    }


    sealed class UiEffect {
        data object GoToNextScreen : UiEffect()
    }
}