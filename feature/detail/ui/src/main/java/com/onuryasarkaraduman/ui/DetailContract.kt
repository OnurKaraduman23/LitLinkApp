package com.onuryasarkaraduman.ui

import com.onuryasarkaraduman.datasource.user.ReadingStatus
import com.onuryasarkaraduman.domain.model.BookDetailModel

internal object DetailContract {
    data class UiState(
        val currentUserId: String? = null,
        val isLoading: Boolean = false,
        val bookDetails: BookDetailModel? = null,
        val isBottomSheetVisible: Boolean = false,
        val selectedReadingStatus: ReadingStatus = ReadingStatus.NONE,
        val whichCategoryAdded: ReadingStatus = ReadingStatus.NONE
    )

    sealed interface UiAction {
        data object OnClick : UiAction
        data object OnBackClick : UiAction
        data object OnBottomSheetOpen : UiAction
        data object OnBottomSheetDismiss : UiAction
        data class OnReadingStatusSelected(val status: ReadingStatus) : UiAction
        data object OnSaveClick : UiAction
    }

    sealed interface UiEffect {
        data class ShowError(val errorMessage: String) : UiEffect
        data class ShowMessage(val message: kotlin.String) : UiEffect
        data object NavigateOtherScreen : UiEffect
        data object NavigateBack : UiEffect
    }

}