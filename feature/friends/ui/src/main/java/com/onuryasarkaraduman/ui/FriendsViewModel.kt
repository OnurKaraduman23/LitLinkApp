package com.onuryasarkaraduman.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.onuryasarkaraduman.auth.FirebaseAuthRepository
import com.onuryasarkaraduman.firestore.books.BookRepository
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
    private val bookRepository: BookRepository,
    private val authRepository: FirebaseAuthRepository,
) : ViewModel(),
    MVI<UiState, UIAction, UIEffect> by mvi(UiState()) {

    init {
        isBookAdded()
    }

    override fun onAction(uiAction: UIAction) {
        viewModelScope.launch {
            when (uiAction) {
                is UIAction.OnClick -> {}
                is UIAction.OnBackClick -> {
                    emitUiEffect(UIEffect.NavigateBack)
                }

                is UIAction.OnAddBooksClick -> {
                    emitUiEffect(UIEffect.NavigateSearchBook)
                }
                is UIAction.OnAddFriendsClick -> {
                    emitUiEffect(UIEffect.NavigateAddFriends)
                }
            }
        }

    }


    private fun getFriends() = viewModelScope.launch {

    }


    private fun isBookAdded() = viewModelScope.launch {
        updateUiState { copy(isLoading = true) }
        val currentUserId = authRepository.getCurrentUserId()
        val isBookAdded = bookRepository.hasUserAddedAnyBooks(userId = currentUserId.orEmpty())
        updateUiState { copy(isLoading = false, isBookAdded = isBookAdded) }
    }

    private fun isHaveAnyFriends() = viewModelScope.launch {

    }

}
