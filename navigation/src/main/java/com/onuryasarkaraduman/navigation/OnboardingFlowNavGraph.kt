package com.onuryasarkaraduman.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigation
import com.onuryasarkaraduman.ui.navigation.CategoriesSelector
import com.onuryasarkaraduman.ui.navigation.Home
import com.onuryasarkaraduman.ui.navigation.Screen
import com.onuryasarkaraduman.ui.navigation.categoriesSelectorScreen
import com.onuryasarkaraduman.ui.navigation.welcomeScreen
import kotlinx.serialization.Serializable

@Serializable
object OnboardingFlow : Screen

internal fun NavGraphBuilder.onboardingFlowNavigation(navController: NavHostController) {
    navigation<OnboardingFlow>(CategoriesSelector) {
        welcomeScreen(
            onNavigateCategoriesSelector = {navController.navigate(CategoriesSelector)}
        )
        categoriesSelectorScreen(onNavigateNextScreen = { navController.navigate(Home) })
    }
}