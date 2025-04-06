package com.onuryasarkaraduman.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.onuryasarkaraduman.core.ui.R


@Composable
internal fun NoBooksSection(
    onClick: () -> Unit,
) {
    Column(
        modifier = Modifier
            .padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AppText(
            modifier = Modifier,
            color = Color.Gray,
            text = stringResource(id = R.string.you_must_added_books),
        )
        Spacer(modifier = Modifier.height(24.dp))
        AddButton(
            text = stringResource(R.string.add_books),
            onClickAdd = { onClick() }
        )
    }

}

@Preview(showBackground = true)
@Composable
internal fun NoBooksSectionPreview() {
    NoBooksSection(
        onClick = {}
    )
}