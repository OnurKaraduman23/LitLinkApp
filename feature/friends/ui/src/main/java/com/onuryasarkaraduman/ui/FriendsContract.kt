package com.onuryasarkaraduman.ui

import com.onuryasarkaraduman.datasource.user.Friend

internal object FriendsContract {
    data class UiState(
        val isLoading: Boolean = false,
        val isBookAdded: Boolean = false,
        val isHaveAnyFriends: Boolean = false,
        val friendsList: List<Friend> = emptyList()
    )

    sealed interface UIAction{
        data object OnClick: UIAction
        data object OnBackClick : UIAction
        data object OnAddBooksClick: UIAction
        data object OnAddFriendsClick: UIAction

    }

    sealed interface UIEffect{
        data object NavigateBack : UIEffect
        data object NavigateSearchBook: UIEffect
        data object NavigateAddFriends: UIEffect
    }
}