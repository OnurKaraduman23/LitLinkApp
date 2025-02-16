package com.onuryasarkaraduman.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage

@Composable
fun AppAsyncImage(
    modifier: Modifier = Modifier,
    imageUrl: String,
    contentScale: ContentScale = ContentScale.Crop,
    contentDescription: String,
) {
    AsyncImage(
        modifier = modifier,
        model = imageUrl,
        contentScale = contentScale,
        contentDescription = contentDescription,
    )
}