package com.onuryasarkaraduman.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.onuryasarkaraduman.ui.AddFriendsScreen
import kotlinx.serialization.Serializable


@Serializable
data object AddFriends : Screen


fun NavGraphBuilder.addFriendsScreen(
    onNavigateBack: () -> Unit,
) {

    composable<AddFriends> {
        AddFriendsScreen()
    }
}