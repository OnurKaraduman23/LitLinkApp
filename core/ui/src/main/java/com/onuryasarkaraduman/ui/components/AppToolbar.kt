package com.onuryasarkaraduman.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.onuryasarkaraduman.core.ui.R

@Composable
fun AppToolbar(
    title: String? = null,
    onBackClick: (() -> Unit)? = null,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (onBackClick != null) {
            Box(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .size(24.dp)
                    .clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() }
                    ) { onBackClick() },
                contentAlignment = Alignment.Center,
            ) {
                Icon(
                    modifier = Modifier.size(28.dp),
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = stringResource(R.string.back_icon_description)
                )
            }

            title?.let {
                Box(
                    modifier = Modifier
                        .weight(1f),
                    contentAlignment = Alignment.Center
                ) {
                    HeaderText(text = title)
                }
            }

            Spacer(modifier = Modifier.size(24.dp))
        } else {
            title?.let {
                Box(
                    modifier = Modifier
                        .padding(start = 16.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    HeaderText(text = title)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppToolbarPreview() {
    AppToolbar(
        title = stringResource(R.string.welcome),
    )
}

@Preview(showBackground = true)
@Composable
fun AppToolbarBackClickPreview() {
    AppToolbar(
        title = stringResource(R.string.welcome),
        onBackClick = {}
    )
}
