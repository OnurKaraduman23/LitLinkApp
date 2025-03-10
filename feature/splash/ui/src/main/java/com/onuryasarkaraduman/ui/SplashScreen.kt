package com.onuryasarkaraduman.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.onuryasarkaraduman.ui.extensions.collectWithLifecycle
import kotlinx.coroutines.flow.Flow
import com.onuryasarkaraduman.core.ui.R

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
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.splash_lottie))
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LottieAnimation(modifier = Modifier.size(350.dp), composition = composition)
    }
}