package com.onuryasarkaraduman.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.onuryasarkaraduman.ui.welcome.WelcomeScreen
import kotlinx.serialization.Serializable

@Serializable
data object Welcome : Screen

fun NavGraphBuilder.welcomeScreen(
    onNavigateCategoriesSelector: () -> Unit,
) {
    composable<Welcome> {
        WelcomeScreen(
            onNavigateCategoriesSelector = onNavigateCategoriesSelector
        )
    }
}

