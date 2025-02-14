package com.onuryasarkaraduman.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigation
import com.onuryasarkaraduman.ui.navigation.Screen
import kotlinx.serialization.Serializable

@Serializable
object SplashFlow : Screen

internal fun NavGraphBuilder.splashFlowNavigation(navController: NavHostController) {
//    navigation<LoginFlow>(Welcome) {
//
//    }
}