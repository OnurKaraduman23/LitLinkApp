package com.onuryasarkaraduman.ui.categories_selector

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.onuryasarkaraduman.ui.navigation.Screen
import kotlinx.serialization.Serializable

@Serializable
data object CategoriesSelector : Screen

fun NavGraphBuilder.categoriesSelectorScreen(

) {
    composable<CategoriesSelector> {

        CategoriesSelectorScreen()
    }
}
