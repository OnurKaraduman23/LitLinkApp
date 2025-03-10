package com.onuryasarkaraduman.litlinkapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.onuryasarkaraduman.connectivity.ConnectivityListener
import com.onuryasarkaraduman.litlinkapp.MainContract.UiAction
import com.onuryasarkaraduman.litlinkapp.MainContract.UiState
import com.onuryasarkaraduman.ui.delegate.mvi.MVI
import com.onuryasarkaraduman.ui.delegate.mvi.mvi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val connectivityListener: ConnectivityListener,
) : ViewModel(),
    MVI<UiState, UiAction, Unit> by mvi(UiState()) {

        init {
            listenConnectivity()
        }

    override fun onAction(uiAction: UiAction) {
        when (uiAction) {
            UiAction.DismissNoNetworkDialog -> updateUiState { copy(isShowNoNetworkDialog = false) }
        }
    }


    private fun listenConnectivity() {
        viewModelScope.launch {
            connectivityListener.isNetworkAvailable.collect {
                if (!it) updateUiState { copy(isShowNoNetworkDialog = true) }
            }
        }
    }
}