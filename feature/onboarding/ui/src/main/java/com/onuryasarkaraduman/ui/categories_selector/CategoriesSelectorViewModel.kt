package com.onuryasarkaraduman.ui.categories_selector

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.onuryasarkaraduman.datasource.user_categories.UserCategories
import com.onuryasarkaraduman.datastore.DataStoreHelper
import com.onuryasarkaraduman.ui.categories_selector.CategoriesContract.UiAction
import com.onuryasarkaraduman.ui.categories_selector.CategoriesContract.UiEffect
import com.onuryasarkaraduman.ui.categories_selector.CategoriesContract.UiState
import com.onuryasarkaraduman.ui.delegate.mvi.MVI
import com.onuryasarkaraduman.ui.delegate.mvi.mvi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class CategoriesSelectorViewModel @Inject constructor(
    private val dataStore: DataStoreHelper,
) : ViewModel(),
    MVI<UiState, UiAction, UiEffect> by mvi(UiState()) {

    override fun onAction(uiAction: UiAction) {
        when (uiAction) {
            is UiAction.SaveCategories -> saveSelectedCategories(uiAction.selectedStatesList)
        }
    }


    private fun saveSelectedCategories(selectedStates: List<Boolean>) = viewModelScope.launch {

        val selectedCategories = UserCategories.entries
            .filterIndexed { index, _ -> selectedStates[index] }
            .map { it.value }
        dataStore.saveCategories(selectedCategories)
        emitUiEffect(UiEffect.GoToNextScreen)
    }


}
