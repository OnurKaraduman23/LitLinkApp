package com.onuryasarkaraduman.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.onuryasarkaraduman.common.fold
import com.onuryasarkaraduman.datastore.DataStoreHelper
import com.onuryasarkaraduman.domain.use_case.GetBooksByCategoriesUseCase
import com.onuryasarkaraduman.ui.HomeContract.UiAction
import com.onuryasarkaraduman.ui.HomeContract.UiEffect
import com.onuryasarkaraduman.ui.HomeContract.UiState
import com.onuryasarkaraduman.ui.delegate.mvi.MVI
import com.onuryasarkaraduman.ui.delegate.mvi.mvi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class HomeViewModel @Inject constructor(
    private val getBooksByCategoriesUseCase: GetBooksByCategoriesUseCase,
    private val dataStore: DataStoreHelper,
) : ViewModel(),
    MVI<UiState, UiAction, UiEffect> by mvi(UiState()) {

    init {
        getBooksByCategories()
        getUserSelectedCategories()
    }

    override fun onAction(uiAction: UiAction) {
        when (uiAction) {
            is UiAction.OnClick -> {}
        }
    }

    private fun getBooksByCategories() = viewModelScope.launch {
        updateUiState { copy(isLoading = true) }
        getBooksByCategoriesUseCase("science").fold(
            onSuccess = {
                updateUiState { copy(recommendedList = it, isLoading = false) }
                Log.e("Dante", it.toString())
            },
            onError = {
                updateUiState { copy(isLoading = false) }
                emitUiEffect(UiEffect.ShowError(it.message.orEmpty()))
            }
        )
    }

    private fun getUserSelectedCategories() {
        viewModelScope.launch {
            val result = dataStore.getUserCategories().collect {
                Log.e("Dante", it.toString())
            }

        }
    }
}