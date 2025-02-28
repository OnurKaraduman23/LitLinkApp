package com.onuryasarkaraduman.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.onuryasarkaraduman.ui.navigation.CategoriesSelector
import com.onuryasarkaraduman.ui.navigation.Home
import com.onuryasarkaraduman.ui.navigation.Splash
import com.onuryasarkaraduman.ui.navigation.Welcome
import com.onuryasarkaraduman.ui.navigation.splashScreen
import com.onuryasarkaraduman.ui.navigation.welcomeScreen

@Composable
fun AppNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = Splash,
        modifier = modifier
    ) {
//        homeScreen()
//        welcomeScreen(onNavigateCategoriesSelector = { navController.navigate(CategoriesSelector) })
        splashScreen(
            onNavigateLogin = {},
            onNavigateHome = {navController.navigate(Home)},
            onNavigateOnboarding = {navController.navigate(Welcome)}
        )

        onboardingFlowNavigation(navController = navController)
        splashFlowNavigation(navController = navController)
        mainFlowNavigation(navController = navController)
        loginFlowNavigation(navController = navController)
    }
}