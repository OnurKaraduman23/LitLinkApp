package com.onuryasarkaraduman.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.onuryasarkaraduman.auth.FirebaseAuthRepository
import com.onuryasarkaraduman.ui.delegate.mvi.MVI
import com.onuryasarkaraduman.ui.delegate.mvi.mvi
import com.onuryasarkaraduman.ui.navigation.ProfileContract.UiAction
import com.onuryasarkaraduman.ui.navigation.ProfileContract.UiEffect
import com.onuryasarkaraduman.ui.navigation.ProfileContract.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class ProfileViewModel @Inject constructor(
    private val firebaseAuthRepository: FirebaseAuthRepository,
) : ViewModel(), MVI<UiState, UiAction, UiEffect> by mvi(UiState()) {

    override fun onAction(uiAction: UiAction) {
        viewModelScope.launch {
            when (uiAction) {
                is UiAction.OnSignOutClick -> signOut()
            }
        }
    }


    private fun signOut() = viewModelScope.launch {
        firebaseAuthRepository.signOut()
        emitUiEffect(UiEffect.NavigateToLogin)
    }

}

