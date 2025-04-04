package com.onuryasarkaraduman.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.onuryasarkaraduman.auth.FirebaseAuthRepository
import com.onuryasarkaraduman.common.fold
import com.onuryasarkaraduman.datastore.DataStoreHelper
import com.onuryasarkaraduman.domain.use_case.GetBooksByCategoriesUseCase
import com.onuryasarkaraduman.domain.use_case.GetRandomCategoryUseCase
import com.onuryasarkaraduman.firestore.user.UserRepository
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
    private val userRepository: UserRepository,
    private val authRepository: FirebaseAuthRepository,

    ) : ViewModel(),
    MVI<UiState, UiAction, UiEffect> by mvi(UiState()) {

    init {
        getUserSelectedCategoriesBooks()

    }

    override fun onAction(uiAction: UiAction) {
        viewModelScope.launch {
            when (uiAction) {
                is UiAction.OnClick -> {}
                is UiAction.CategorySelected -> {
                    updateUiState { copy(userSelectedCategory = uiAction.category) }
                    getBooksByCategories(uiAction.category)
                }

                is UiAction.OnBooksClick -> {
                    emitUiEffect(UiEffect.NavigateDetail(uiAction.bookId))
                }

                is UiAction.AddFriendsClick -> {
                    emitUiEffect(UiEffect.NavigateFriends)
                }
            }
        }

    }

    private fun getBooksByCategories(selectedCategory: String) = viewModelScope.launch {
        updateUiState { copy(isLoading = true, userSelectedCategory = selectedCategory) }
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
                getBooksByCategories(selectedCategory = selectedCategory)
            }

        }
    }



}