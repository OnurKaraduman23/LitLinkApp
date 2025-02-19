package com.onuryasarkaraduman.ui.welcome

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.onuryasarkaraduman.ui.navigation.Screen
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

