package com.onuryasarkaraduman.ui.navigation

import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.onuryasarkaraduman.ui.ProfileScreen
import com.onuryasarkaraduman.ui.ProfileViewModel
import kotlinx.serialization.Serializable

@Serializable
data object Profile : Screen

fun NavGraphBuilder.profileScreen(
    onNavigateLogin: () -> Unit,
) {
    composable<Profile> {
        val viewModel = hiltViewModel<ProfileViewModel>()
        val uiState by viewModel.uiState.collectAsStateWithLifecycle()
        val uiEffect = viewModel.uiEffect
        ProfileScreen(
            uiState = uiState,
            uiEffect = uiEffect,
            onAction = viewModel::onAction,
            onNavigateLogin = onNavigateLogin
        )
    }
}