package com.onuryasarkaraduman.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.onuryasarkaraduman.ui.SearchContract.UIAction
import com.onuryasarkaraduman.ui.SearchContract.UIEffect
import com.onuryasarkaraduman.ui.SearchContract.UIState
import com.onuryasarkaraduman.ui.extensions.collectWithLifecycle
import kotlinx.coroutines.flow.Flow

@Composable
internal fun SearchScreen(
    uiState: UIState,
    uiEffect: Flow<UIEffect>,
    onAction: (UIAction) -> Unit,
    onNavigateDetail: (String) -> Unit,
    onNavigateBack: () -> Unit,
) {
    uiEffect.collectWithLifecycle { effect ->
        when (effect) {
            is UIEffect.NavigateDetail -> {
                onNavigateDetail(effect.id)
            }

            is UIEffect.NavigateBack -> onNavigateBack()
        }

    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Search Screen")
    }
}