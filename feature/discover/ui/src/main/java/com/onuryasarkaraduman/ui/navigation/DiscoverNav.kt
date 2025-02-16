package com.onuryasarkaraduman.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.onuryasarkaraduman.ui.DiscoverScreen
import kotlinx.serialization.Serializable

@Serializable
data object Discover : Screen

fun NavGraphBuilder.discoverScreen(

) {
    composable<Discover> {
        DiscoverScreen()
    }
}