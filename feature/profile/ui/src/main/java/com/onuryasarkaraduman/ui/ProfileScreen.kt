package com.onuryasarkaraduman.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.onuryasarkaraduman.ui.extensions.collectWithLifecycle
import com.onuryasarkaraduman.ui.navigation.ProfileContract.UiAction
import com.onuryasarkaraduman.ui.navigation.ProfileContract.UiEffect
import com.onuryasarkaraduman.ui.navigation.ProfileContract.UiState
import kotlinx.coroutines.flow.Flow

@Composable
internal fun ProfileScreen(
    uiState: UiState,
    uiEffect: Flow<UiEffect>,
    onAction: (UiAction) -> Unit,
    onNavigateLogin: () -> Unit,

    ) {

    uiEffect.collectWithLifecycle { uiEffect ->
        when (uiEffect) {
            is UiEffect.NavigateToLogin -> onNavigateLogin()
        }

    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Profile Screen")
        Button(onClick = { onAction(UiAction.OnSignOutClick) }) {
            Text("Sign Out")
        }
    }
}