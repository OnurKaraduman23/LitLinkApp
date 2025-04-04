package com.onuryasarkaraduman.ui

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.onuryasarkaraduman.auth.FirebaseAuthRepository
import com.onuryasarkaraduman.common.fold
import com.onuryasarkaraduman.datasource.user.CompletedBooks
import com.onuryasarkaraduman.datasource.user.PlannedBooks
import com.onuryasarkaraduman.datasource.user.ReadingBooks
import com.onuryasarkaraduman.datasource.user.ReadingStatus
import com.onuryasarkaraduman.domain.model.BookDetailModel
import com.onuryasarkaraduman.domain.use_case.GetBookDetailsUseCase
import com.onuryasarkaraduman.firestore.books.BookRepository
import com.onuryasarkaraduman.ui.DetailContract.UiAction
import com.onuryasarkaraduman.ui.DetailContract.UiEffect
import com.onuryasarkaraduman.ui.DetailContract.UiState
import com.onuryasarkaraduman.ui.delegate.mvi.MVI
import com.onuryasarkaraduman.ui.delegate.mvi.mvi
import com.onuryasarkaraduman.ui.navigation.Detail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

@HiltViewModel
internal class DetailViewModel @Inject constructor(
    private val getBookDetailsUseCase: GetBookDetailsUseCase,
    private val bookRepository: BookRepository,
    private val authRepository: FirebaseAuthRepository,
    savedStateHandle: SavedStateHandle,
) : ViewModel(),
    MVI<UiState, UiAction, UiEffect> by mvi(UiState()) {


    init {

        val args: Detail = savedStateHandle.toRoute()
        fetchCurrentUser(args.bookId)
        getBooksDetail(args.bookId)
//        checkAddedBook(currentUser =uiState.value.currentUser!!, bookId = args.id)
    }

    override fun onAction(uiAction: UiAction) {
        viewModelScope.launch {
            when (uiAction) {
                is UiAction.OnClick -> {}
                is UiAction.OnBackClick -> emitUiEffect(UiEffect.NavigateBack)
                is UiAction.OnBottomSheetOpen -> updateUiState { copy(isBottomSheetVisible = true) }
                is UiAction.OnBottomSheetDismiss -> updateUiState { copy(isBottomSheetVisible = false) }
                is UiAction.OnReadingStatusSelected -> {
                    updateUiState { copy(selectedReadingStatus = uiAction.status) }
                }

                is UiAction.OnSaveClick -> {
                    val currentUserId = authRepository.getCurrentUserId()
                    val bookDetails = uiState.value.bookDetails
                    val selectedStatus = uiState.value.selectedReadingStatus

                    if (currentUserId != null && bookDetails != null) {
                        when (selectedStatus) {
                            ReadingStatus.READ -> saveCompletedBook(currentUserId, bookDetails)
                            ReadingStatus.WILL_READ -> savePlannedBook(currentUserId, bookDetails)
                            ReadingStatus.READING -> saveReadingBook(currentUserId, bookDetails)
                            ReadingStatus.NONE -> emitUiEffect(UiEffect.ShowMessage("Please select a reading status"))
                        }
                        if (selectedStatus != ReadingStatus.NONE) {
                            updateUiState { copy(whichCategoryAdded = selectedStatus, isBottomSheetVisible = false) }
                        } else {
                            updateUiState { copy(isBottomSheetVisible = false) }
                        }

                    } else {
                        emitUiEffect(UiEffect.ShowError("No user or book information found"))
                    }
                }
            }
        }
    }

    private fun saveCompletedBook(userId: String, bookDetails: BookDetailModel) {
        viewModelScope.launch {
            updateUiState { copy(isLoading = true) }
            try {
                val completedBook = CompletedBooks(
                    bookId = bookDetails.id,
                    bookName = bookDetails.bookTitle,
                    bookImageUrl = bookDetails.mediumImageUrl

                )
                bookRepository.addCompleteBook(
                    userId = userId,
                    completedBooks = completedBook
                ).await()
                emitUiEffect(UiEffect.ShowMessage("Book added to your completed list successfully"))
                updateUiState { copy(isLoading = false) }
            } catch (e: Exception) {
                emitUiEffect(UiEffect.ShowError(e.message ?: "Unknown error occurred"))
                updateUiState { copy(isLoading = false) }
            }
        }
    }

    private fun savePlannedBook(userId: String, bookDetails: BookDetailModel) {
        viewModelScope.launch {
            updateUiState { copy(isLoading = true) }
            try {
                val plannedBook = PlannedBooks(
                    bookId = bookDetails.id,
                    bookName = bookDetails.bookTitle,
                    bookImageUrl = bookDetails.largeImageUrl
                )
                bookRepository.addPlannedBooks(
                    userId = userId,
                    plannedBooks = plannedBook
                ).await()
                emitUiEffect(UiEffect.ShowMessage("Book added to to-read list"))
                updateUiState { copy(isLoading = false) }
            } catch (e: Exception) {
                emitUiEffect(UiEffect.ShowError(e.message ?: "Unknown error occurred"))
                updateUiState { copy(isLoading = false) }
            }
        }
    }

    private fun saveReadingBook(userId: String, bookDetails: BookDetailModel) {
        viewModelScope.launch {
            updateUiState { copy(isLoading = true) }
            try {
                val readingBook = ReadingBooks(
                    bookId = bookDetails.id,
                    bookName = bookDetails.bookTitle,
                    bookImageUrl = bookDetails.largeImageUrl
                )
                bookRepository.addReadingBook(
                    userId = userId,
                    currentReadingBooks = readingBook
                ).await()
                emitUiEffect(UiEffect.ShowMessage("Added to reading books list"))
                updateUiState { copy(isLoading = false) }
            } catch (e: Exception) {
                emitUiEffect(UiEffect.ShowError(e.message ?: "Unknown error occurred"))
                updateUiState { copy(isLoading = false) }
            }
        }
    }

    private fun checkAddedBook(userId: String, bookId: String) {
        viewModelScope.launch {
            updateUiState { copy(isLoading = true) }
            val addedCategory =
                bookRepository.checkAddedUserBook(userId = userId, bookId = bookId)
            updateUiState { copy(isLoading = false, whichCategoryAdded = addedCategory, selectedReadingStatus = addedCategory) }
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
                updateUiState { copy(isLoading = false) }
                Log.e("Dante", "Book Detail Error ${exception.message}")
            }
        )
    }

    private fun fetchCurrentUser(bookId: String) = viewModelScope.launch {
        updateUiState { copy(isLoading = true) }
        val currentUserId = authRepository.getCurrentUserId()
        checkAddedBook(userId = currentUserId.orEmpty(), bookId = bookId)

    }
}