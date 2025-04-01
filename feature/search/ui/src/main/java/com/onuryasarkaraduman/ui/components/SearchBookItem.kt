package com.onuryasarkaraduman.ui.components

import android.R.attr.id
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.onuryasarkaraduman.domain.model.SearchBooksModel
import com.onuryasarkaraduman.ui.extensions.boldBorder
import com.onuryasarkaraduman.ui.extensions.noRippleClickable
import com.onuryasarkaraduman.core.ui.R

@Composable
internal fun SearchBookItem(
    item: SearchBooksModel,
    onBooksClick: (String) -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(145.dp)
            .padding(vertical = 8.dp)
            .background(
                color = Color.White,
                shape = RoundedCornerShape(16.dp),
            )
            .boldBorder(color = colorResource(id = R.color.yellow))
            .noRippleClickable { onBooksClick(item.id) },
        verticalAlignment = Alignment.CenterVertically,
    ) {
        AppAsyncImage(
            modifier = Modifier.padding(8.dp),
            imageUrl = item.bookUrl,
            size = 100,
            contentDescription = item.bookName
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            HeaderText(
                modifier = Modifier,
                text = item.bookName,
                maxLines = 1,
                fontSize = 18
            )
            Spacer(modifier = Modifier.height(8.dp))
            AppText(
                modifier = Modifier,
                text = item.authors.joinToString(", "),
                color = Color.LightGray,

            )
            Spacer(modifier = Modifier)
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                AppText(
                    modifier = Modifier,
                    text = item.category,
                    color = Color.Green
                )
            }

        }


    }
}

@Preview(showBackground = true)
@Composable
internal fun SearchBookItemPreview() {
    SearchBookItem(
        item = SearchBooksModel(
            id = "afagag",
            bookName = "Dante's Inferno",
            bookUrl = "",
            category = "Art",
            authors = listOf("Author 1", "Author 2"),
        ),
        onBooksClick = {}
    )
}