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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.onuryasarkaraduman.ui.components.FriendsItemHome
import com.onuryasarkaraduman.ui.components.HeaderText

@Composable
fun HomeScreen() {
    val viewModel: HomeViewModel = hiltViewModel()
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        Spacer(modifier = Modifier.height(12.dp))
        HeaderText(text = "Welcome")
        Spacer(modifier = Modifier.height(12.dp))
        FriendsSection()
    }
}

@Composable
internal fun HomeContent(){

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