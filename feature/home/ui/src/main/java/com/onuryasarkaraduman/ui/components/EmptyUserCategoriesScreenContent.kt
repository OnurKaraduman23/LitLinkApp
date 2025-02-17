package com.onuryasarkaraduman.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.unit.dp
import com.onuryasarkaraduman.core.ui.R

@Composable
internal fun EmptyUserCategoriesScreenContent() {
    Column(
        modifier = Modifier.fillMaxWidth()
            .height(250.dp)
            .padding(horizontal = 16.dp)
            .border(width = 2.dp, color = colorResource(id = R.color.yellow)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Icon(
            modifier = Modifier.size(144.dp),
            painter = painterResource(id =  R.drawable.ic_error),
            tint = colorResource(id = R.color.yellow),
            contentDescription = stringResource(id = R.string.empty_content),
        )
        Spacer(modifier = Modifier.height(8.dp))
        AppText(
            text = stringResource(R.string.empty_content)
        )
    }
}