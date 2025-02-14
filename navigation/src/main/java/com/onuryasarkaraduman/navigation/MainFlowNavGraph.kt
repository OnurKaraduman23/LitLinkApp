package com.onuryasarkaraduman.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigation
import com.onuryasarkaraduman.ui.navigation.Home
import com.onuryasarkaraduman.ui.navigation.Screen
import kotlinx.serialization.Serializable

@Serializable
object MainFlow : Screen

internal fun NavGraphBuilder.mainFlowNavigation(navController: NavHostController) {
    navigation<MainFlow>(Home) {
        // homeScreen, other Screens
    }
}