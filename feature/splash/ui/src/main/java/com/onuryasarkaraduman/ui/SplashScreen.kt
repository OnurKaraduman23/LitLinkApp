package com.onuryasarkaraduman.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.onuryasarkaraduman.ui.extensions.collectWithLifecycle
import kotlinx.coroutines.flow.Flow

@Composable
internal fun SplashScreen(
    uiEffect: Flow<SplashContract.UiEffect>,
    onNavigateOnboarding: () -> Unit,
    onNavigateLogin: () -> Unit,
    onNavigateHome: () -> Unit,
) {

    uiEffect.collectWithLifecycle {effect ->
        when(effect) {
            is SplashContract.UiEffect.NavigateOnboarding -> onNavigateOnboarding()
            is SplashContract.UiEffect.NavigateLogin -> onNavigateLogin()
            is SplashContract.UiEffect.NavigateHome -> onNavigateHome()
        }

    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Splash Screen")
    }
}