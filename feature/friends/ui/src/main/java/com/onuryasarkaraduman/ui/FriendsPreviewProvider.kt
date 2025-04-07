package com.onuryasarkaraduman.ui

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

internal class FriendsPreviewProvider : PreviewParameterProvider<FriendsContract.UiState> {
    override val values: Sequence<FriendsContract.UiState>
        get() = sequenceOf(
            FriendsContract.UiState(
                isLoading = true
            ),
            FriendsContract.UiState(
                isLoading = false,
                isBookAdded = true
            ),
            FriendsContract.UiState(
                isHaveAnyFriends = true
            ),


        )
}