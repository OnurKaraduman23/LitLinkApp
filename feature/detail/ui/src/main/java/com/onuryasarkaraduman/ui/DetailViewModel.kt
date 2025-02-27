package com.onuryasarkaraduman.ui

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.onuryasarkaraduman.common.fold
import com.onuryasarkaraduman.domain.use_case.GetBookDetailsUseCase
import com.onuryasarkaraduman.ui.DetailContract.UiEffect
import com.onuryasarkaraduman.ui.DetailContract.UiAction
import com.onuryasarkaraduman.ui.DetailContract.UiState
import com.onuryasarkaraduman.ui.delegate.mvi.MVI
import com.onuryasarkaraduman.ui.delegate.mvi.mvi
import com.onuryasarkaraduman.ui.navigation.Detail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class DetailViewModel @Inject constructor(
    private val getBookDetailsUseCase: GetBookDetailsUseCase,
    savedStateHandle: SavedStateHandle,
) : ViewModel(),
    MVI<UiState, UiAction, UiEffect> by mvi(UiState()) {


    init {
        val args: Detail = savedStateHandle.toRoute()
        getBooksDetail(args.id)
    }

    override fun onAction(uiAction: UiAction) {
        viewModelScope.launch{
            when (uiAction) {
                is UiAction.OnClick -> {}
                is UiAction.OnBackClick -> emitUiEffect(UiEffect.NavigateBack)
            }
        }

    }

    private fun getBooksDetail(bookId: String) = viewModelScope.launch {
        updateUiState { copy(isLoading = true) }
        getBookDetailsUseCase(bookId = bookId).fold(
            onSuccess = { bookDetailModel ->
                updateUiState { copy(isLoading = false, bookDetails = bookDetailModel) }
                Log.e("Dante", "Book Detail $bookDetailModel")
            },
            onError = { exception ->
                Log.e("Dante", "Book Detail Error ${exception.message}")
            }
        )
    }
}