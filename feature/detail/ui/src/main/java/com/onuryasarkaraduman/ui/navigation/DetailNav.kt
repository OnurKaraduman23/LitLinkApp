package com.onuryasarkaraduman.ui.navigation

import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.onuryasarkaraduman.ui.DetailScreen
import com.onuryasarkaraduman.ui.DetailViewModel
import kotlinx.serialization.Serializable

@Serializable
data class Detail(val bookId: String) : Screen

fun NavGraphBuilder.detailScreen(
    onNavigateBack: () -> Unit,
) {


    composable<Detail> {
        val viewModel: DetailViewModel = hiltViewModel()
        val uiState by viewModel.uiState.collectAsStateWithLifecycle()
        val uiEffect = viewModel.uiEffect
        DetailScreen(
            uiState = uiState,
            uiEffect = uiEffect,
            onAction = viewModel::onAction,
            onNavigateBack = onNavigateBack
        )
    }
}