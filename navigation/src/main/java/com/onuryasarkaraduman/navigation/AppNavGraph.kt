package com.onuryasarkaraduman.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.onuryasarkaraduman.ui.welcome.Welcome
import com.onuryasarkaraduman.ui.welcome.welcomeScreen
import com.onuryasarkaraduman.ui.categories_selector.CategoriesSelector

@Composable
fun AppNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = Welcome,
        modifier = modifier
    ) {
//        homeScreen()
        welcomeScreen(onNavigateCategoriesSelector = { navController.navigate(CategoriesSelector) })

        onboardingFlowNavigation(navController = navController)
        splashFlowNavigation(navController = navController)
        mainFlowNavigation(navController = navController)
        loginFlowNavigation(navController = navController)
    }
}