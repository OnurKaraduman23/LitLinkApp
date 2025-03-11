package com.onuryasarkaraduman.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.onuryasarkaraduman.ui.FriendsScreen
import kotlinx.serialization.Serializable

@Serializable
data object Friends:Screen


fun NavGraphBuilder.friendsScreen(

){
    composable<Friends> {
        FriendsScreen()
    }
}
