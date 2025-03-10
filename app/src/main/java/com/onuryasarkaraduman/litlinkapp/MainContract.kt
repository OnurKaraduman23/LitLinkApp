package com.onuryasarkaraduman.litlinkapp

object MainContract {
    data class UiState(
        val isShowNoNetworkDialog: Boolean = false,
    )

    sealed interface UiAction {
        data object DismissNoNetworkDialog : UiAction
    }

}