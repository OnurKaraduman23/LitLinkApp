package com.onuryasarkaraduman.ui

import com.onuryasarkaraduman.datasource.user.Friend

internal object FriendsContract {
    data class UiState(
        val isLoading: Boolean = false,
        val isBookAdded: Boolean = false,
        val friendsList: List<Friend> = emptyList()
    )

    sealed interface UIAction{
        data object OnClick: UIAction
        data object OnBackClick : UIAction

    }

    sealed interface UIEffect{
        data object NavigateBack : UIEffect
    }
}