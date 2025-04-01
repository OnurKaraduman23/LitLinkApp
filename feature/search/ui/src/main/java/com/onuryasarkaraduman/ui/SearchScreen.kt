package com.onuryasarkaraduman.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.onuryasarkaraduman.core.ui.R
import com.onuryasarkaraduman.ui.SearchContract.UIAction
import com.onuryasarkaraduman.ui.SearchContract.UIEffect
import com.onuryasarkaraduman.ui.SearchContract.UIState
import com.onuryasarkaraduman.ui.components.AppLoadingXLarge
import com.onuryasarkaraduman.ui.components.AppSearchBar
import com.onuryasarkaraduman.ui.components.AppToolbar
import com.onuryasarkaraduman.ui.components.EmptySearchContent
import com.onuryasarkaraduman.ui.components.SearchBookItem
import com.onuryasarkaraduman.ui.extensions.collectWithLifecycle
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

@Composable
internal fun SearchScreen(
    uiState: UIState,
    uiEffect: Flow<UIEffect>,
    onAction: (UIAction) -> Unit,
    onNavigateDetail: (String) -> Unit,
    onNavigateBack: () -> Unit,
) {
    uiEffect.collectWithLifecycle { effect ->
        when (effect) {
            is UIEffect.NavigateDetail -> {
                onNavigateDetail(effect.id)
            }

            is UIEffect.NavigateBack -> onNavigateBack()
        }

    }
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        AppToolbar(
            onBackClick = { onAction(UIAction.OnBackClick) },
            title = stringResource(id = R.string.search)
        )
        AppSearchBar(
            modifier = Modifier.padding(horizontal = 32.dp),
            value = uiState.query,
            onValueChange = { onAction(UIAction.OnQueryChange(it)) },
        )
        Spacer(modifier = Modifier.height(24.dp))
        SearchContent(
            uiState = uiState,
            onAction = onAction,
        )
    }

    if (uiState.isLoading) AppLoadingXLarge()
}

@Composable
internal fun SearchContent(
    uiState: UIState,
    onAction: (UIAction) -> Unit,
) {
    if (uiState.booksList.isEmpty() && !uiState.isLoading) {
        EmptySearchContent()
    } else {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(horizontal = 32.dp),
        ) {
            items(uiState.booksList) { book ->
                SearchBookItem(
                    item = book,
                    onBooksClick = { onAction(UIAction.OnBookClick(it)) }
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun SearchScreenPreview() {
    SearchScreen(
        uiState = UIState(),
        uiEffect = flow { },
        onAction = {},
        onNavigateBack = {},
        onNavigateDetail = {}
    )
}