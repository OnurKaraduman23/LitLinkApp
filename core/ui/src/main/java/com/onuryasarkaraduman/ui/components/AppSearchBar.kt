package com.onuryasarkaraduman.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.onuryasarkaraduman.core.ui.R
import com.onuryasarkaraduman.ui.extensions.boldBorder
import com.onuryasarkaraduman.ui.extensions.conditional
import com.onuryasarkaraduman.ui.extensions.noRippleClickable

@Composable
fun AppSearchBar(
    modifier: Modifier = Modifier,
    value: String = "",
    onClick: (() -> Unit)? = null,
    onValueChange: (String) -> Unit = {},
) {
    BasicTextField(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .clip(RoundedCornerShape(16.dp))
            .boldBorder(color = colorResource(id = R.color.yellow)),
        value = value,
        onValueChange = onValueChange,
        singleLine = true,
        decorationBox = {
            Box(
                modifier = Modifier
                    .conditional(onClick != null) {
                        noRippleClickable { onClick?.invoke() }
                    }
                    .padding(16.dp),
                contentAlignment = Alignment.CenterStart,
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_search),
                        tint = Color.Black,
                        contentDescription = stringResource(R.string.search_image_content_description),
                    )
                    if (value.isBlank()) {
                        AppText(
                            text = stringResource(R.string.search_books),
                            color = Color.LightGray,
                            fontSize = 22,
                        )
                    } else {
                        it()
                    }
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun AppSearchBarPreview(){
    AppSearchBar(
        value = "AppSearchBar",
        onValueChange = {},
    )
}


