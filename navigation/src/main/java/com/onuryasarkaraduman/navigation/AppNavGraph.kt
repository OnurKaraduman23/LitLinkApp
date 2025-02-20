package com.onuryasarkaraduman.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.onuryasarkaraduman.ui.navigation.CategoriesSelector
import com.onuryasarkaraduman.ui.navigation.Welcome
import com.onuryasarkaraduman.ui.navigation.welcomeScreen

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