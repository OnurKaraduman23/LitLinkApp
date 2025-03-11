package com.onuryasarkaraduman.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
internal fun FriendsScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Friends Screen")
        /**
         * KİTAP EKLENMEMISSE KULLANICI ARKADAŞ LİSTELEYEMEMELİ
         *      bu durumu kullancıya bildir.
         */
    }
}


@Preview(showBackground = true)
@Composable
internal fun FriendsScreenPreview() {
    FriendsScreen()
}