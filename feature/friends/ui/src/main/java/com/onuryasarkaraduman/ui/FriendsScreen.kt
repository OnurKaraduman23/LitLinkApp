package com.onuryasarkaraduman.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.onuryasarkaraduman.core.ui.R
import com.onuryasarkaraduman.ui.FriendsContract.UIAction
import com.onuryasarkaraduman.ui.FriendsContract.UIEffect
import com.onuryasarkaraduman.ui.FriendsContract.UiState
import com.onuryasarkaraduman.ui.components.AppLoadingXLarge
import com.onuryasarkaraduman.ui.components.AppToolbar
import com.onuryasarkaraduman.ui.components.NoBooksSection
import com.onuryasarkaraduman.ui.components.NoHaveAnyFriendsSection
import com.onuryasarkaraduman.ui.extensions.collectWithLifecycle
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

@Composable
internal fun FriendsScreen(
    uiState: UiState,
    uiEffect: Flow<UIEffect>,
    onAction: (UIAction) -> Unit,
    onNavigateBack: () -> Unit,
    onNavigateSearchBooks: () -> Unit,
) {

    uiEffect.collectWithLifecycle { effect ->
        when (effect) {
            is UIEffect.NavigateBack -> onNavigateBack()
            is UIEffect.NavigateSearchBook -> {
                onNavigateSearchBooks()
            }
            is UIEffect.NavigateAddFriends -> {
                //TODO: Arkadaş ekleme ekranına yönlendirilecek
            }
        }

    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AppToolbar(
            title = stringResource(R.string.friends),
            onBackClick = { onAction(UIAction.OnBackClick) },
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (uiState.isLoading) AppLoadingXLarge()
            else if (!uiState.isBookAdded) {
                // Kullanıcı hiç kitap eklemediyse, kitap ekleme bölümünü göster
                // Arkadaşı olsa bile öncelik kitap eklemede
                NoBooksSection(
                    onClick = { onAction(UIAction.OnAddBooksClick) }
                )
            } else if (uiState.isHaveAnyFriends) {
                //Kullanıcının kitapları ve arkadaşları varsa, arkadaşları göster
                FriendsSection(
                    onClick = {
                        //TODO: Arkadaş ile sohbete veya profile yönlendirilecek
                    }
                )
            } else {
                // Kullanıcının kitapları var ama arkadaşı yoksa, arkadaş ekleme bildirimi göster
                NoHaveAnyFriendsSection(
                    onClick = {
                        //TODO: Arkadaş ekleme ekranına yönlendirilecek
                    }
                )
            }

        }

    }
}

@Composable
internal fun ColumnScope.FriendsSection(
    onClick:() -> Unit
){

}

@Preview(showBackground = true)
@Composable
internal fun FriendsScreenPreview() {
    FriendsScreen(
        uiState = UiState(),
        uiEffect = flow { },
        onAction = {},
        onNavigateBack = {},
        onNavigateSearchBooks = {}

    )
}