package com.onuryasarkaraduman.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.onuryasarkaraduman.common.fold
import com.onuryasarkaraduman.domain.use_case.GetSearchBooksUseCase
import com.onuryasarkaraduman.ui.SearchBooksContract.UIAction
import com.onuryasarkaraduman.ui.SearchBooksContract.UIEffect
import com.onuryasarkaraduman.ui.SearchBooksContract.UIState
import com.onuryasarkaraduman.ui.delegate.mvi.MVI
import com.onuryasarkaraduman.ui.delegate.mvi.mvi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class SearchViewModel @Inject constructor(
    private val searchBooksUseCase: GetSearchBooksUseCase,
) : ViewModel(),
    MVI<UIState, UIAction, UIEffect> by mvi(UIState()) {


    override fun onAction(uiAction: UIAction) {
        viewModelScope.launch {
            when (uiAction) {
                is UIAction.OnBackClick -> emitUiEffect(UIEffect.NavigateBack)
                is UIAction.OnBookClick -> emitUiEffect(UIEffect.NavigateDetail(uiAction.id))
                is UIAction.OnQueryChange -> {
                    updateUiState { copy(query = uiAction.query) }
                    if (uiAction.query.length > 2) {
                        searchBook()
                    } else {
                        updateUiState { copy(booksList = initialBooksList) }
                    }
                }
            }
        }
    }


    private fun searchBook() = viewModelScope.launch {
        updateUiState { copy(isLoading = true) }
        searchBooksUseCase(currentUiState.query).fold(
            onSuccess = {
                updateUiState {
                    copy(
                        booksList = it,
                        initialBooksList = it,
                        isLoading = false
                    )
                }
            },
            onError = { updateUiState { copy(booksList = emptyList(), isLoading = false) } }
        )
    }
}