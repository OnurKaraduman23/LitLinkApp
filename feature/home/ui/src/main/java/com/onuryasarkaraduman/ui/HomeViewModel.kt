package com.onuryasarkaraduman.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.onuryasarkaraduman.common.fold
import com.onuryasarkaraduman.datastore.DataStoreHelper
import com.onuryasarkaraduman.domain.use_case.GetBooksByCategoriesUseCase
import com.onuryasarkaraduman.domain.use_case.GetRandomCategoryUseCase
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
    private val getRandomCategoryUseCase: GetRandomCategoryUseCase,
    private val dataStore: DataStoreHelper,
) : ViewModel(),
    MVI<UiState, UiAction, UiEffect> by mvi(UiState()) {

    init {
        getUserSelectedCategoriesBooks()

    }

    override fun onAction(uiAction: UiAction) {
        when (uiAction) {
            is UiAction.OnClick -> {}
        }
    }

    private fun getBooksByCategories(selectedCategory: String) = viewModelScope.launch {
        updateUiState { copy(isLoading = true) }
        getBooksByCategoriesUseCase(selectedCategory).fold(
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

    private fun getUserSelectedCategoriesBooks() {
        viewModelScope.launch {
            dataStore.getUserCategories().collect {
                updateUiState { copy(userCategoryList = it) }
                val selectedCategory = getRandomCategoryUseCase.execute(it)
                updateUiState { copy(userSelectedCategory = selectedCategory) }
                getBooksByCategories(selectedCategory = selectedCategory)
            }

        }
    }


}