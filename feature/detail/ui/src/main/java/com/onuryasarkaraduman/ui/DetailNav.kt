package com.onuryasarkaraduman.ui

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.onuryasarkaraduman.ui.navigation.Screen
import kotlinx.serialization.Serializable

@Serializable
data class Detail(val id: Int) : Screen

fun NavGraphBuilder.detailScreen() {

    composable<Detail> {
        DetailScreen()
    }
}