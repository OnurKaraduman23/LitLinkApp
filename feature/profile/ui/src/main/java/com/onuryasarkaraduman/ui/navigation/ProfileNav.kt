package com.onuryasarkaraduman.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.onuryasarkaraduman.ui.ProfileScreen
import kotlinx.serialization.Serializable

@Serializable
data object Profile : Screen

fun NavGraphBuilder.profileScreen(
) {
    composable<Profile> {
        ProfileScreen()
    }
}