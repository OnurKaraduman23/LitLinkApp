package com.onuryasarkaraduman.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.onuryasarkaraduman.core.ui.R


@Composable
internal fun ColumnScope.NoBooksSection(
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
            text = stringResource(id = R.string.you_must_added_books),
        )
        AddButton(
            text = stringResource(R.string.add_books),
            onClickAdd = { onClick() }
        )
    }

}

