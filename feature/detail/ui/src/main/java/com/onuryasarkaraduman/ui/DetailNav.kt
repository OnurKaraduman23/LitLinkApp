package com.onuryasarkaraduman.ui

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.onuryasarkaraduman.ui.navigation.Screen
import kotlinx.serialization.Serializable

@Serializable
data class Detail(val id: String) : Screen

fun NavGraphBuilder.detailScreen() {


    composable<Detail> {
        val viewModel: DetailViewModel = hiltViewModel()
        DetailScreen()
    }
}