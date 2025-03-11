package com.onuryasarkaraduman.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.onuryasarkaraduman.auth.FirebaseAuthRepository
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
    private val firebaseAuth: FirebaseAuthRepository,
) : ViewModel(),
    MVI<Unit, Unit, UiEffect> by mvi(Unit) {


    init {
        checkOnboardingState()
    }

    private fun checkOnboardingState() = viewModelScope.launch {
        delay(3000)
        dataStore.getOnboardingState().collect { state ->
            screenTransition(onBoardingState = state)
        }
    }

    private fun screenTransition(onBoardingState: Boolean) = viewModelScope.launch {
        Log.e("Dante", "Onbs: $onBoardingState isLgdIn: ${isLoggedIn()}")
        emitUiEffect(
            if (onBoardingState && isLoggedIn()) {
                UiEffect.NavigateHome

            } else if (onBoardingState && !isLoggedIn()) {
                UiEffect.NavigateLogin
            } else if (!onBoardingState) {
                UiEffect.NavigateOnboarding
            } else {
                UiEffect.NavigateLogin
            }
        )
    }

    private fun isLoggedIn(): Boolean {
        return firebaseAuth.isUserLoggedIn()
    }


}