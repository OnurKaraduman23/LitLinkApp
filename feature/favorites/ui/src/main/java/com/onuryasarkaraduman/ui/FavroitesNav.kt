package com.onuryasarkaraduman.ui

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.onuryasarkaraduman.ui.navigation.Screen
import kotlinx.serialization.Serializable

@Serializable
data object Favorites : Screen

fun NavGraphBuilder.favoritesScreen(
    onNavigateSecondScreen: () -> Unit,
) {
    composable<Favorites> {
        FavoritesScreen()
    }
}