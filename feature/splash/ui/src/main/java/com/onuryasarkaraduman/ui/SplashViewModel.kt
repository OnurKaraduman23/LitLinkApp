package com.onuryasarkaraduman.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.onuryasarkaraduman.datastore.DataStoreHelper
import com.onuryasarkaraduman.ui.SplashContract.UiEffect
import com.onuryasarkaraduman.ui.delegate.mvi.MVI
import com.onuryasarkaraduman.ui.delegate.mvi.mvi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class SplashViewModel @Inject constructor(
    private val dataStore: DataStoreHelper,
) : ViewModel(),
    MVI<Unit, Unit, UiEffect> by mvi(Unit) {


    init {
        checkOnboardingState()
    }

    private fun checkOnboardingState() = viewModelScope.launch {
        delay(2000)
        dataStore.getOnboardingState().collect { state ->
            screenTransition(onBoardingState = state)
        }
    }

    private fun screenTransition(onBoardingState: Boolean) = viewModelScope.launch {
        emitUiEffect(if (onBoardingState) UiEffect.NavigateHome else UiEffect.NavigateOnboarding)
    }


}