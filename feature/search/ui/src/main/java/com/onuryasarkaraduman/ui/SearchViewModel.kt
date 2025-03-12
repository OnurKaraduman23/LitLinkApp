package com.onuryasarkaraduman.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.onuryasarkaraduman.ui.SearchContract.UIAction
import com.onuryasarkaraduman.ui.SearchContract.UIEffect
import com.onuryasarkaraduman.ui.SearchContract.UIState
import com.onuryasarkaraduman.ui.delegate.mvi.MVI
import com.onuryasarkaraduman.ui.delegate.mvi.mvi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class SearchViewModel @Inject constructor(

) : ViewModel(),
    MVI<UIState, UIAction, UIEffect> by mvi(UIState()) {


    override fun onAction(uiAction: UIAction) {
        viewModelScope.launch {
            when (uiAction) {
                is UIAction.OnBookClick -> {}
                is UIAction.OnQueryChange -> {searchBook()}
            }
        }
    }

    private fun searchBook(){

    }
}