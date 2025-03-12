package com.onuryasarkaraduman.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.onuryasarkaraduman.ui.FriendsContract.UIAction
import com.onuryasarkaraduman.ui.FriendsContract.UIEffect
import com.onuryasarkaraduman.ui.FriendsContract.UiState
import com.onuryasarkaraduman.ui.delegate.mvi.MVI
import com.onuryasarkaraduman.ui.delegate.mvi.mvi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class FriendsViewModel @Inject constructor(

) : ViewModel(),
    MVI<UiState, UIAction, UIEffect> by mvi(UiState()) {

    override fun onAction(uiAction: UIAction) {
        viewModelScope.launch {
            when (uiAction) {
                is UIAction.OnClick -> {}
                is UIAction.OnBackClick -> {emitUiEffect(UIEffect.NavigateBack)}
            }
        }

    }


    private fun getFriends() = viewModelScope.launch {

    }

}

/**
 * KİTAP EKLENMEZSE KULLANICI ARKADAŞ LİSTELEYEMEMELİ
 *
 */