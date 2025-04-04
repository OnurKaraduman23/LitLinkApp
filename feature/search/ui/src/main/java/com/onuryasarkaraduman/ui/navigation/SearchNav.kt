package com.onuryasarkaraduman.ui.navigation

import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.onuryasarkaraduman.ui.SearchScreen
import com.onuryasarkaraduman.ui.SearchViewModel
import kotlinx.serialization.Serializable

@Serializable
data object Search : Screen

fun NavGraphBuilder.searchScreen(
    onNavigateDetail: (String) -> Unit,
) {

    composable<Search> {
        val viewModel = hiltViewModel<SearchViewModel>()
        val uiState by viewModel.uiState.collectAsStateWithLifecycle()
        val uiEffect = viewModel.uiEffect
        SearchScreen(
            uiState = uiState,
            uiEffect = uiEffect,
            onAction = viewModel::onAction,
            onNavigateDetail = onNavigateDetail,
        )
    }
}