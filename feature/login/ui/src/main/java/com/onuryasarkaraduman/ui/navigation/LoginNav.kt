package com.onuryasarkaraduman.ui.navigation

import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.onuryasarkaraduman.ui.LoginScreen
import com.onuryasarkaraduman.ui.LoginViewModel
import kotlinx.serialization.Serializable

@Serializable
data object Login : Screen

fun NavGraphBuilder.loginScreen(
    onNavigateRegister: () -> Unit,
    onNavigateHome: () -> Unit,
) {
    composable<Login> {
        val viewModel = hiltViewModel<LoginViewModel>()
        val uiState by viewModel.uiState.collectAsStateWithLifecycle()
        val uiEffect = viewModel.uiEffect
        LoginScreen(
            uiState = uiState,
            uiEffect = uiEffect,
            onAction = viewModel::onAction,
            onNavigateRegister = onNavigateRegister,
            onNavigateHome = onNavigateHome
        )


    }

}