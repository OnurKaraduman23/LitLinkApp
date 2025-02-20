package com.onuryasarkaraduman.ui.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.onuryasarkaraduman.ui.categories_selector.CategoriesSelectorScreen
import com.onuryasarkaraduman.ui.categories_selector.CategoriesSelectorViewModel
import kotlinx.serialization.Serializable

@Serializable
data object CategoriesSelector : Screen

fun NavGraphBuilder.categoriesSelectorScreen(
    onNavigateNextScreen: () -> Unit,
) {
    composable<CategoriesSelector> {
        val viewModel: CategoriesSelectorViewModel = hiltViewModel()
        val uiEffect = viewModel.uiEffect
        CategoriesSelectorScreen(
            onAction = viewModel::onAction,
            uiEffect = uiEffect,
            onNavigateNextScreen = onNavigateNextScreen,

            )
    }
}
