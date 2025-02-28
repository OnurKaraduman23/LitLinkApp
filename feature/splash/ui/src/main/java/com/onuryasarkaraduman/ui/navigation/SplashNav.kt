package com.onuryasarkaraduman.ui.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.onuryasarkaraduman.ui.SplashScreen
import com.onuryasarkaraduman.ui.SplashViewModel
import kotlinx.serialization.Serializable

@Serializable
data object Splash : Screen

fun NavGraphBuilder.splashScreen(
    onNavigateLogin: () -> Unit,
    onNavigateHome: () -> Unit,
    onNavigateOnboarding: () -> Unit,
) {
    composable<Splash> {
        val viewModel = hiltViewModel<SplashViewModel>()
        val uiEffect = viewModel.uiEffect
        SplashScreen(
            onNavigateLogin = onNavigateLogin,
            onNavigateHome = onNavigateHome,
            onNavigateOnboarding = onNavigateOnboarding,
            uiEffect = uiEffect
        )
    }

}