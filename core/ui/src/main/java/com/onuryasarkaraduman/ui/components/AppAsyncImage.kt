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
    modifier: Modifier = Modifier,
    imageUrl: String,
    contentDescription: String? = null,
    size: Int = 175
) {
    GlideImage(
        modifier = modifier
            .size(size.dp),
        model = imageUrl,
        contentDescription = "Product thumbnail image",
        contentScale = ContentScale.Fit,

        ) {
        it.load(imageUrl)
            .placeholder(R.drawable.art)
            .error(R.drawable.art)
    }
}