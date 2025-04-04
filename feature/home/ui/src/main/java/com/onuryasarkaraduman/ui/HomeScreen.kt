package com.onuryasarkaraduman.ui

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.onuryasarkaraduman.core.ui.R
import com.onuryasarkaraduman.domain.model.CategoriesRecommendedModel
import com.onuryasarkaraduman.ui.HomeContract.UiAction
import com.onuryasarkaraduman.ui.HomeContract.UiEffect
import com.onuryasarkaraduman.ui.HomeContract.UiState
import com.onuryasarkaraduman.ui.components.AppLoadingSmall
import com.onuryasarkaraduman.ui.components.AppToolbar
import com.onuryasarkaraduman.ui.components.CategorySelectionTextField
import com.onuryasarkaraduman.ui.components.EmptyFriendsBooksContent
import com.onuryasarkaraduman.ui.components.EmptyUserCategoriesScreenContent
import com.onuryasarkaraduman.ui.components.FriendsItemHome
import com.onuryasarkaraduman.ui.components.HeaderText
import com.onuryasarkaraduman.ui.components.HomeRecommendedCategoriesCard
import com.onuryasarkaraduman.ui.extensions.collectWithLifecycle
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

@Composable
internal fun HomeScreen(
    uiState: UiState,
    uiEffect: Flow<UiEffect>,
    onAction: (UiAction) -> Unit,
    onNavigateDetail: (String) -> Unit,
    onNavigateFriends: () -> Unit,
) {
    val context = LocalContext.current

    LaunchedEffect(uiState.userSelectedCategory) {
        onAction(UiAction.CategorySelected(uiState.userSelectedCategory))
    }

    uiEffect.collectWithLifecycle { effect ->
        when (effect) {
            is UiEffect.ShowError -> {
                Toast.makeText(context, effect.message, Toast.LENGTH_SHORT).show()
            }

            is UiEffect.NavigateDetail -> onNavigateDetail(effect.bookId)
            is UiEffect.NavigateFriends -> onNavigateFriends()
        }
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        AppToolbar(title = stringResource(id = R.string.welcome))

        HomeContent(uiState, onAction, onNavigateDetail, onNavigateFriends)
    }
}

@Composable
internal fun HomeContent(
    uiState: UiState,
    onAction: (UiAction) -> Unit,
    onNavigateDetail: (String) -> Unit,
    onNavigateFriends: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        HorizontalDivider(
            modifier = Modifier.padding(vertical = 12.dp),
            thickness = 1.dp,
            color = Color.Black
        )

        FriendsSection()
        HorizontalDivider(
            modifier = Modifier.padding(vertical = 12.dp),
            thickness = 1.dp,
            color = colorResource(id = R.color.yellow)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            HeaderText(text = stringResource(id = R.string.user_category))
            if (uiState.userSelectedCategory.isNotEmpty()) {
                CategorySelectionTextField(
                    items = uiState.userCategoryList,
                    selectedItem = uiState.userSelectedCategory,
                    showBottomSheetState = false,
                    onCategorySelected = { selectedCategory ->
                        onAction(UiAction.CategorySelected(selectedCategory))
                    }
                )
            }
        }
        Spacer(modifier = Modifier.height(12.dp))
        if (uiState.isLoading) {
            AppLoadingSmall()
        } else {
            UserCategorySection(
                recommendedList = uiState.recommendedList,
                onItemClick = { selectedId ->
                    onAction(UiAction.OnBooksClick(selectedId))
                }
            )
        }


        HorizontalDivider(
            modifier = Modifier.padding(vertical = 12.dp),
            thickness = 2.dp,
            color = colorResource(id = R.color.yellow)
        )

        HeaderText(
            modifier = Modifier.align(Alignment.Start),
            text = stringResource(id = R.string.friends_books)
        )
        Spacer(modifier = Modifier.height(12.dp))
        FriendsBooksSection(
            friendsBooksList = uiState.friendsBooksList,
            onItemClick = { selectedId ->
                onNavigateDetail(selectedId)
            },
            onClickAddFriends = {
                onAction(UiAction.AddFriendsClick)
            }
        )
    }
}

@Composable
internal fun ColumnScope.UserCategorySection(
    recommendedList: List<CategoriesRecommendedModel>,
    onItemClick: (String) -> Unit,
) {
    if (recommendedList.isEmpty()) {
        EmptyUserCategoriesScreenContent()
    } else {
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(elevation = 24.dp, shape = RectangleShape, clip = false)
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 16.dp),
        ) {
            items(recommendedList) {
                HomeRecommendedCategoriesCard(
                    book = it,
                    onClick = { onItemClick(it.id) }
                )


            }
        }
    }
}

@Composable
internal fun ColumnScope.FriendsBooksSection(
    friendsBooksList: List<CategoriesRecommendedModel>,
    onItemClick: (String) -> Unit,
    onClickAddFriends: () -> Unit,
) {
    if (friendsBooksList.isEmpty()) {
        EmptyFriendsBooksContent(onClickAddFriends = { onClickAddFriends() })
    } else {
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(elevation = 24.dp, shape = RectangleShape, clip = false)
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 16.dp),
        ) {
            items(friendsBooksList) {
                HomeRecommendedCategoriesCard(
                    book = it,
                    onClick = {}
                )


            }
        }
    }
}


@Composable
internal fun ColumnScope.FriendsSection() {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(10) {
            FriendsItemHome()
        }
    }
}

@Preview(showBackground = true)
@Composable
internal fun HomeScreenPreview(
    @PreviewParameter(HomePreviewProvider::class) uiState: UiState,
) {

    HomeScreen(
        uiState = uiState,
        uiEffect = flow { },
        onAction = {},
        onNavigateDetail = {},
        onNavigateFriends = {}
    )
}