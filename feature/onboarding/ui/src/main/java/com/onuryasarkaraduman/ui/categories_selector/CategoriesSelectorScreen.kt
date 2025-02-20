package com.onuryasarkaraduman.ui.categories_selector


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.onuryasarkaraduman.core.ui.R
import com.onuryasarkaraduman.datasource.user_categories.UserCategories
import com.onuryasarkaraduman.ui.categories_selector.CategoriesContract.UiAction
import com.onuryasarkaraduman.ui.categories_selector.CategoriesContract.UiEffect
import com.onuryasarkaraduman.ui.categories_selector.components.CategoryCard
import com.onuryasarkaraduman.ui.components.CutCornerButton
import com.onuryasarkaraduman.ui.extensions.collectWithLifecycle
import kotlinx.coroutines.flow.Flow

@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun CategoriesSelectorScreen(
    onAction: (UiAction) -> Unit,
    uiEffect: Flow<UiEffect>,
    onNavigateNextScreen: () -> Unit,
) {

    uiEffect.collectWithLifecycle { effect ->
        when (effect) {
            UiEffect.GoToNextScreen -> onNavigateNextScreen()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CategoriesContent(onAction = onAction)

    }
}


@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun ColumnScope.CategoriesContent(
    onAction: (UiAction) -> Unit,
) {

    val selectedStates = remember {
        mutableStateListOf<Boolean>().apply {
            addAll(List(UserCategories.entries.count()) { false })
        }
    }

    Column(
        modifier = Modifier
            .weight(1f)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            UserCategories.entries.forEachIndexed { index, category ->
                CategoryCard(
                    title = stringResource(id = category.displayName),
                    image = category.imageResource,
                    isSelected = selectedStates[index],
                    onToggleSelect = { selectedStates[index] = !selectedStates[index] }
                )
            }
        }
    }
    CutCornerButton(
        text = stringResource(id = R.string.next),
        isEnabled = selectedStates.count { it } >= 4,
        onClick = {
            val selectedStatesList = selectedStates.toList()
            onAction(UiAction.SaveCategories(selectedStatesList = selectedStatesList))
        }
    )

}
