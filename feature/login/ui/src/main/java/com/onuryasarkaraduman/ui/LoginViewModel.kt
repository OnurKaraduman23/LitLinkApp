package com.onuryasarkaraduman.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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

) : ViewModel(), MVI<UiState, UiAction, UiEffect> by mvi(UiState()) {

    override fun onAction(uiAction: UiAction) {
        viewModelScope.launch {
            when (uiAction) {
                is UiAction.OnLoginClick -> {}
                is UiAction.OnBackClick -> {}
                is UiAction.OnRegisterClick -> {}
                is UiAction.OnForgotPasswordClick -> {}
                is UiAction.OnEmailChange -> {}
                is UiAction.OnPasswordChange -> {}
            }
        }

    }

    private fun login() = viewModelScope.launch {

    }

}