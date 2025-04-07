package com.onuryasarkaraduman.ui.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.onuryasarkaraduman.ui.FriendsScreen
import com.onuryasarkaraduman.ui.FriendsViewModel
import kotlinx.serialization.Serializable
import androidx.compose.runtime.getValue

@Serializable
data object Friends : Screen


fun NavGraphBuilder.friendsScreen(
    onNavigateBack: () -> Unit,
    onNavigateSearchBooks: () -> Unit,
    onNavigateAddFriends: () -> Unit

    ) {
    composable<Friends> {
        val viewModel = hiltViewModel<FriendsViewModel>()
        val uiState by viewModel.uiState.collectAsStateWithLifecycle()
        val uiEffect = viewModel.uiEffect
        FriendsScreen(
            uiState = uiState,
            uiEffect = uiEffect,
            onAction = viewModel::onAction,
            onNavigateBack = onNavigateBack,
            onNavigateSearchBooks = onNavigateSearchBooks,
            onNavigateAddFriends = onNavigateAddFriends
        )
    }
}
