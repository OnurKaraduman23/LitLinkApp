package com.onuryasarkaraduman.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.onuryasarkaraduman.ui.HomeScreen
import kotlinx.serialization.Serializable

@Serializable
data object Home : Screen

fun NavGraphBuilder.homeScreen(

) {
    composable<Home> {
        HomeScreen()
    }
}