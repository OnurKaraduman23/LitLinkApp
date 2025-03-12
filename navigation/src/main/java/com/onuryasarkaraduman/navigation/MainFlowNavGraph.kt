package com.onuryasarkaraduman.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigation
import com.onuryasarkaraduman.ui.navigation.Detail
import com.onuryasarkaraduman.ui.navigation.Friends
import com.onuryasarkaraduman.ui.navigation.Home
import com.onuryasarkaraduman.ui.navigation.Login
import com.onuryasarkaraduman.ui.navigation.Screen
import com.onuryasarkaraduman.ui.navigation.Search
import com.onuryasarkaraduman.ui.navigation.detailScreen
import com.onuryasarkaraduman.ui.navigation.discoverScreen
import com.onuryasarkaraduman.ui.navigation.favoritesScreen
import com.onuryasarkaraduman.ui.navigation.friendsScreen
import com.onuryasarkaraduman.ui.navigation.homeScreen
import com.onuryasarkaraduman.ui.navigation.profileScreen
import com.onuryasarkaraduman.ui.navigation.searchScreen
import kotlinx.serialization.Serializable

@Serializable
object MainFlow : Screen

internal fun NavGraphBuilder.mainFlowNavigation(navController: NavHostController) {
    navigation<MainFlow>(Home) {
        homeScreen(
            onNavigateDetail = { navController.navigate(Detail(it)) },
            onNavigateFriends = { navController.navigate(Friends) }
        )
        searchScreen(
            onNavigateDetail = { navController.navigate(Detail(it)) }
        )
        profileScreen(
            onNavigateLogin = {
                navController.navigate(Login) {
                    popUpTo(navController.graph.startDestinationId) { inclusive = true }
                    launchSingleTop = true
                }

            }
        )
        favoritesScreen()
        discoverScreen()
        detailScreen(
            onNavigateBack = { navController.popBackStack() }
        )
        friendsScreen(
            onNavigateBack = { navController.popBackStack() },
            onNavigateSearchBooks = {navController.navigate(Search)}
        )
    }
}