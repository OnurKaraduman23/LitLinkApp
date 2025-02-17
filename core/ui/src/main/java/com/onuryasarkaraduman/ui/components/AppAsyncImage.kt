package com.onuryasarkaraduman.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.onuryasarkaraduman.core.ui.R

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun AppAsyncImage(
    imageUrl: String,
    contentDescription: String? = null
) {
    GlideImage(
        model = imageUrl,
        contentDescription = "Product thumbnail image",
        contentScale = ContentScale.Fit,
        modifier = Modifier
            .size(175.dp)
    ) {
        it.load(imageUrl)
            .placeholder(R.drawable.art)
            .error(R.drawable.art)
    }
}