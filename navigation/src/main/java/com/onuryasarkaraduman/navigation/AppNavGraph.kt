package com.onuryasarkaraduman.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.onuryasarkaraduman.ui.navigation.Home

@Composable
fun AppNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = Home,
        modifier = modifier
    ) {
        // SplashScreen()

        splashFlowNavigation(navController = navController)
        mainFlowNavigation(navController = navController)
        loginFlowNavigation(navController = navController)
    }
}