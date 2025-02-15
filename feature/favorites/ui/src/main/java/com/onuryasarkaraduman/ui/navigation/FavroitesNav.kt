package com.onuryasarkaraduman.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.onuryasarkaraduman.ui.FavoritesScreen
import kotlinx.serialization.Serializable

@Serializable
data object Favorites : Screen

fun NavGraphBuilder.favoritesScreen(
) {
    composable<Favorites> {
        FavoritesScreen()
    }
}