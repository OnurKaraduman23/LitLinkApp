package com.onuryasarkaraduman.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigation
import com.onuryasarkaraduman.ui.navigation.Home
import com.onuryasarkaraduman.ui.navigation.Login
import com.onuryasarkaraduman.ui.navigation.Register
import com.onuryasarkaraduman.ui.navigation.Screen
import com.onuryasarkaraduman.ui.navigation.loginScreen
import com.onuryasarkaraduman.ui.navigation.registerScreen
import kotlinx.serialization.Serializable

@Serializable
object LoginFlow : Screen

internal fun NavGraphBuilder.loginFlowNavigation(navController: NavHostController) {
    navigation<LoginFlow>(Login) {


        loginScreen(
            onNavigateBack = { navController.popBackStack() },
            onNavigateRegister = { navController.navigate(Register) },
            onNavigateHome = { navController.navigate(Home) }
        )
        registerScreen(
            onNavigateLogin = { navController.navigate(Login) },
            onNavigateHome = { navController.navigate(Home) },
            onNavigateBack = { navController.popBackStack() }
        )
    }
}