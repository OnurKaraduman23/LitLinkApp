package com.onuryasarkaraduman.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.onuryasarkaraduman.core.ui.R

@Composable
 fun EmptyScreenContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Icon(
            modifier = Modifier.size(144.dp),
            painter = painterResource(id = R.drawable.ic_error),
            tint = colorResource(id = R.color.yellow),
            contentDescription = stringResource(R.string.empty_content),
        )
        Spacer(modifier = Modifier.height(48.dp))
        AppText(
            text = stringResource(R.string.empty_content),
            textAlign = TextAlign.Center,
        )
    }
}

@Preview(showBackground = true)
@Composable
internal fun EmptyScreenContentPreview() {
    EmptyScreenContent()
}