package com.onuryasarkaraduman.ui

import androidx.compose.runtime.Composable
import com.onuryasarkaraduman.ui.RegisterContract.UiAction
import com.onuryasarkaraduman.ui.RegisterContract.UiEffect
import com.onuryasarkaraduman.ui.RegisterContract.UiState
import kotlinx.coroutines.flow.Flow


@Composable
internal fun RegisterScreen(
    uiState: UiState,
    uiEffect: Flow<UiEffect>,
    onAction: (UiAction) -> Unit,
    onNavigateBack: () -> Unit,
    onNavigateHome: () -> Unit,
    onNavigateLogin: () -> Unit,
) {

}

@Composable
internal fun RegisterContent() {

}