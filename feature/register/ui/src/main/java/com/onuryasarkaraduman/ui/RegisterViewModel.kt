package com.onuryasarkaraduman.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.onuryasarkaraduman.auth.FirebaseAuthRepository
import com.onuryasarkaraduman.common.fold
import com.onuryasarkaraduman.ui.RegisterContract.UiAction
import com.onuryasarkaraduman.ui.RegisterContract.UiEffect
import com.onuryasarkaraduman.ui.RegisterContract.UiState
import com.onuryasarkaraduman.ui.delegate.mvi.MVI
import com.onuryasarkaraduman.ui.delegate.mvi.mvi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class RegisterViewModel @Inject constructor(
    private val firebaseAuth: FirebaseAuthRepository,
) : ViewModel(), MVI<UiState, UiAction, UiEffect> by mvi(UiState()) {

    override fun onAction(uiAction: UiAction) {
        viewModelScope.launch {
            when (uiAction) {
                is UiAction.OnRegisterClick -> register()
                is UiAction.OnBackClick -> emitUiEffect(UiEffect.NavigateBack)
                is UiAction.OnLoginClick -> emitUiEffect(UiEffect.NavigateLogin)
                is UiAction.OnEmailChange -> updateUiState { copy(email = uiAction.email) }
                is UiAction.OnPasswordChange -> updateUiState { copy(password = uiAction.password) }
                is UiAction.OnUsernameChange -> updateUiState { copy(username = uiAction.username) }
                is UiAction.OnPasswordAgainChange -> updateUiState { copy(passwordAgain = uiAction.passwordAgain) }
            }
        }

    }

    private fun register() = viewModelScope.launch {
        updateUiState { copy(isLoading = true) }
        if (uiState.value.password == uiState.value.passwordAgain) {
            firebaseAuth.signUp(
                email = uiState.value.email,
                password = uiState.value.password,
                userName = uiState.value.username
            ).fold(
                onSuccess = {
                    updateUiState { copy(isLoading = false) }
                    emitUiEffect(UiEffect.NavigateHome)
                },
                onError = {
                    updateUiState { copy(isLoading = false) }
                    Log.e("Dante", "Error ${it.message}")
                }
            )
        } else {
//            emitUiEffect(UiEffect.ShowErrorMessage("Passwords do not match"))
            Log.e("Dante", "Passwords do not match")
        }


    }
}