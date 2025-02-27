package com.onuryasarkaraduman.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.onuryasarkaraduman.core.ui.R
import com.onuryasarkaraduman.domain.model.BookDetailModel
import com.onuryasarkaraduman.ui.DetailContract.UiAction
import com.onuryasarkaraduman.ui.DetailContract.UiEffect
import com.onuryasarkaraduman.ui.DetailContract.UiState
import com.onuryasarkaraduman.ui.components.AppAsyncImage
import com.onuryasarkaraduman.ui.components.AppLoading
import com.onuryasarkaraduman.ui.components.AppRatingBar
import com.onuryasarkaraduman.ui.components.AppText
import com.onuryasarkaraduman.ui.components.AppTextTitle
import com.onuryasarkaraduman.ui.components.AppToolbar
import com.onuryasarkaraduman.ui.components.EmptyScreenContent
import com.onuryasarkaraduman.ui.extensions.collectWithLifecycle
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

@Composable
internal fun DetailScreen(
    uiState: UiState,
    uiEffect: Flow<UiEffect>,
    onAction: (UiAction) -> Unit,
    onNavigateBack: () -> Unit,
) {

    uiEffect.collectWithLifecycle { effect ->
        when (effect) {
            is UiEffect.NavigateOtherScreen -> {

            }

            is UiEffect.ShowError -> {
                // Show Error Message
            }

            is UiEffect.NavigateBack -> onNavigateBack()
        }
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AppToolbar(
            title = stringResource(R.string.detail),
            onBackClick = { onAction(UiAction.OnBackClick) }
        )
        HorizontalDivider(
            modifier = Modifier.padding(vertical = 12.dp),
            thickness = 1.dp,
            color = Color.Black
        )
        if (uiState.isLoading) AppLoading()
        if (uiState.bookDetails == null) EmptyScreenContent()
        DetailContent(
            uiState = uiState,
            onAction = onAction,
        )
    }
}

@Composable
internal fun DetailContent(
    uiState: UiState,
    onAction: (UiAction) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 16.dp),
    ) {
        BookDetailsSection(uiState.bookDetails)
    }
}

@Composable
internal fun SimiliarBooksSection() {
    // Content to be added in the future
}

@Composable
internal fun BookDetailsSection(
    bookDetail: BookDetailModel?,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        // bookDetail null değilse bir blok oluştur
        if (bookDetail != null) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
            ) {
                AppAsyncImage(
                    imageUrl = bookDetail.largeImageUrl,
                    size = 190
                )
                Column {
                    AppTextTitle(
                        modifier = Modifier,
                        text = bookDetail.bookTitle
                    )
                    AppText(
                        modifier = Modifier,
                        text = bookDetail.authors
                    )
                    AppRatingBar(
                        modifier = Modifier,
                        rating = bookDetail.vote
                    )
                }
            }


            BookDetailsTabs(bookDetail)
        }
    }
}


@Composable
internal fun BookDetailsTabs(bookDetail: BookDetailModel) {
    var selectedTabIndex by remember { mutableStateOf(0) }
    val tabs = listOf(
        stringResource(id = R.string.details),
        stringResource(id = R.string.readers),
        stringResource(id = R.string.similiar_books)
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
    ) {

        TabRow(
            selectedTabIndex = selectedTabIndex
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index },
                    text = { Text(title) }
                )
            }
        }


        when (selectedTabIndex) {
            0 -> BookDetailsTabContent(bookDetail)
            1 -> BookReadersTabContent()
            2 -> SimilarBooksTabContent()
        }
    }
}

@Composable
internal fun BookDetailsTabContent(bookDetail: BookDetailModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        AppText(text = "Description: \n ${bookDetail.description} ")

    }
}

@Composable
internal fun BookReadersTabContent() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        AppText(text = "Kitabı Okuyanlar")

    }
}

@Composable
internal fun SimilarBooksTabContent() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        AppText(text = "Benzer kitaplar ")

    }
}

@Preview(showBackground = true)
@Composable
internal fun DetailScreenPreview(
    @PreviewParameter(DetailPreviewProvider::class) uiState: UiState,
) {
    DetailScreen(
        uiState = uiState,
        uiEffect = flow { },
        onAction = {},
        onNavigateBack = {}
    )
}