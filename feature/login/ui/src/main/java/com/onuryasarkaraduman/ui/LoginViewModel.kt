package com.onuryasarkaraduman.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.onuryasarkaraduman.auth.FirebaseAuthRepository
import com.onuryasarkaraduman.common.fold
import com.onuryasarkaraduman.ui.LoginContract.UiAction
import com.onuryasarkaraduman.ui.LoginContract.UiEffect
import com.onuryasarkaraduman.ui.LoginContract.UiState
import com.onuryasarkaraduman.ui.delegate.mvi.MVI
import com.onuryasarkaraduman.ui.delegate.mvi.mvi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class LoginViewModel @Inject constructor(
    private val firebaseAuth: FirebaseAuthRepository,

    ) : ViewModel(), MVI<UiState, UiAction, UiEffect> by mvi(UiState()) {

    override fun onAction(uiAction: UiAction) {
        viewModelScope.launch {
            when (uiAction) {
                is UiAction.OnLoginClick -> login()
                is UiAction.OnRegisterClick -> emitUiEffect(UiEffect.NavigateRegister)
                is UiAction.OnForgotPasswordClick -> {}
                is UiAction.OnEmailChange -> updateUiState { copy(email = uiAction.email) }
                is UiAction.OnPasswordChange -> updateUiState { copy(password = uiAction.password) }
            }
        }
    }

    private fun login() = viewModelScope.launch {
        updateUiState { copy(isLoading = true) }
        firebaseAuth.signIn(
            email = uiState.value.email,
            password = uiState.value.password
        ).fold(
            onSuccess = {
                updateUiState { copy(isLoading = false) }
                emitUiEffect(UiEffect.NavigateHome)
            },
            onError = {
                updateUiState { copy(isLoading = false) }
                Log.e("Dante", "Error ${it.message}")
                // bi şeyler gösterelim (UiEffect falan filan)
            }
        )
    }

}