package com.onuryasarkaraduman.ui

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

internal class LoginPreviewProvider: PreviewParameterProvider<LoginContract.UiState> {
    override val values: Sequence<LoginContract.UiState>
        get()=sequenceOf()
}