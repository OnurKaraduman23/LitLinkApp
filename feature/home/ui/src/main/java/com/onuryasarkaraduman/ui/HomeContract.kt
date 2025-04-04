package com.onuryasarkaraduman.ui

import com.onuryasarkaraduman.domain.model.CategoriesRecommendedModel

internal object HomeContract {
    data class UiState(
        val isLoading: Boolean = true,
        val userCategoryList: List<String> = emptyList(),
        val userSelectedCategory: String = "",
        val recommendedList: List<CategoriesRecommendedModel> = emptyList(),
        val friendsBooksList: List<CategoriesRecommendedModel> = emptyList(),
    )

    sealed interface UiAction {
        data object OnClick : UiAction
        data class CategorySelected(val category: String) : UiAction
        data class OnBooksClick(val bookId: String) : UiAction
        data object AddFriendsClick : UiAction

    }

    sealed interface UiEffect {
        data class ShowError(val message: String) : UiEffect
        data class NavigateDetail(val bookId: String) : UiEffect
        data object NavigateFriends : UiEffect
    }

}