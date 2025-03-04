package com.onuryasarkaraduman.ui.navigation

import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.onuryasarkaraduman.ui.RegisterScreen
import com.onuryasarkaraduman.ui.RegisterViewModel
import kotlinx.serialization.Serializable

@Serializable
data object Register : Screen

fun NavGraphBuilder.registerScreen(
    onNavigateBack: () -> Unit,
    onNavigateLogin: () -> Unit,
    onNavigateHome: () -> Unit,
) {
    composable<Register> {
        val viewModel = hiltViewModel<RegisterViewModel>()
        val uiState by viewModel.uiState.collectAsStateWithLifecycle()
        val uiEffect = viewModel.uiEffect
        RegisterScreen(
            uiState = uiState,
            uiEffect = uiEffect,
            onAction = viewModel::onAction,
            onNavigateBack = onNavigateBack,
            onNavigateHome = onNavigateHome,
            onNavigateLogin = onNavigateLogin
        )


    }

}