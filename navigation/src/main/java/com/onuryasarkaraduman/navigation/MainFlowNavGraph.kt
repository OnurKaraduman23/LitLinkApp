package com.onuryasarkaraduman.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigation
import com.onuryasarkaraduman.ui.navigation.Home
import com.onuryasarkaraduman.ui.navigation.Screen
import com.onuryasarkaraduman.ui.navigation.discoverScreen
import com.onuryasarkaraduman.ui.navigation.favoritesScreen
import com.onuryasarkaraduman.ui.navigation.homeScreen
import com.onuryasarkaraduman.ui.navigation.profileScreen
import com.onuryasarkaraduman.ui.searchScreen
import kotlinx.serialization.Serializable

@Serializable
object MainFlow : Screen

internal fun NavGraphBuilder.mainFlowNavigation(navController: NavHostController) {
    navigation<MainFlow>(Home) {
        homeScreen()
        searchScreen()
        profileScreen()
        favoritesScreen()
        discoverScreen()
    }
}