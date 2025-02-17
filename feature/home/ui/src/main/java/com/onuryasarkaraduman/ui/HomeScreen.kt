package com.onuryasarkaraduman.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.onuryasarkaraduman.core.ui.R
import com.onuryasarkaraduman.domain.model.CategoriesRecommendedModel
import com.onuryasarkaraduman.ui.HomeContract.UiAction
import com.onuryasarkaraduman.ui.HomeContract.UiEffect
import com.onuryasarkaraduman.ui.HomeContract.UiState
import com.onuryasarkaraduman.ui.components.AppLoading
import com.onuryasarkaraduman.ui.components.EmptyFriendsBooksContent
import com.onuryasarkaraduman.ui.components.EmptyUserCategoriesScreenContent
import com.onuryasarkaraduman.ui.components.FriendsItemHome
import com.onuryasarkaraduman.ui.components.HeaderText
import com.onuryasarkaraduman.ui.components.HomeRecommendedCategoriesCard
import com.onuryasarkaraduman.ui.extensions.collectWithLifecycle
import kotlinx.coroutines.flow.Flow

@Composable
internal fun HomeScreen(
    uiState: UiState,
    uiEffect: Flow<UiEffect>,
    onAction: (UiAction) -> Unit,
    onNavigateDetail: (Int) -> Unit,
) {
    uiEffect.collectWithLifecycle { effect ->
        when (effect) {
            is UiEffect.ShowError -> {}
            is UiEffect.NavigateDetail -> {}
        }
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(vertical = 8.dp).verticalScroll(
            rememberScrollState()
        ),
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Spacer(modifier = Modifier.height(12.dp))
        HeaderText(text = stringResource(id = R.string.welcome))

        HorizontalDivider(
            modifier = Modifier.padding(vertical = 12.dp),
            thickness = 1.dp,
            color = Color.Black,
        )

        FriendsSection()
        HorizontalDivider(
            modifier = Modifier.padding(vertical = 12.dp),
            thickness = 1.dp,
            color = colorResource(id = R.color.yellow),
        )

        HeaderText(text = stringResource(id = R.string.user_category))
        Spacer(modifier = Modifier.height(12.dp))
        if (uiState.isLoading) AppLoading()
        UserCategorySection(
            recommendedList = uiState.recommendedList,
            onItemClick = {}
        )
        HorizontalDivider(
            modifier = Modifier.padding(vertical = 12.dp),
            thickness = 2.dp,
            color = colorResource(id = R.color.yellow),
        )
        HeaderText(text = stringResource(id = R.string.friends_books))
        Spacer(modifier = Modifier.height(12.dp))
        FriendsBooksSection(
            friendsBooksList = uiState.friendsBooksList,
            onItemClick = {}
        )
    }
}


@Composable
internal fun ColumnScope.UserCategorySection(
    recommendedList: List<CategoriesRecommendedModel>,
    onItemClick: (Int) -> Unit,
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
                    onClick = {}
                )


            }
        }
    }
}

@Composable
internal fun ColumnScope.FriendsBooksSection(
    friendsBooksList: List<CategoriesRecommendedModel>,
    onItemClick: (Int) -> Unit,
) {
    if (friendsBooksList.isEmpty()) {
        EmptyFriendsBooksContent()
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