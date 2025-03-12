package com.onuryasarkaraduman.ui

internal object SearchContract {

    data class UIState(
        val isLoading: Boolean = false,
        val query: String = "",
    )

    sealed interface UIAction {

        data class OnBookClick(val id: Int) : UIAction
        data class OnQueryChange(val query: String) : UIAction
    }

    sealed interface UIEffect {
        data class NavigateDetail(val id: String) : UIEffect
    }
}