package com.onuryasarkaraduman.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.onuryasarkaraduman.core.ui.R
import com.onuryasarkaraduman.datasource.user.RelatedBooks
import com.onuryasarkaraduman.ui.extensions.noRippleClickable

@Composable
internal fun RelatedBooksItem(
    relatedBooks: List<RelatedBooks?>,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    val maxVisible = 3
    val visibleBooks = relatedBooks.take(maxVisible)
    val remainingCount = relatedBooks.size - maxVisible

    Row(
        modifier = modifier
            .padding(2.dp)
            .noRippleClickable { onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        visibleBooks.forEach { book ->
            AppAsyncCircularImage(
                modifier = Modifier
                    .padding(end = 8.dp)
                    .width(24.dp)
                    .height(24.dp),
                imageUrl = book?.bookUrlSmall ?: ""
            )
        }

        if (remainingCount > 0) {
            MoreRelatedBooksIndicator(remainingCount)
        }
    }
}

@Composable
fun MoreRelatedBooksIndicator(count: Int) {
    Row(
        modifier = Modifier
            .height(24.dp)
            .wrapContentWidth()
            .background(
                color = colorResource(id = R.color.yellow),
                shape = RoundedCornerShape(24.dp)
            )
            .padding(horizontal = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = androidx.compose.foundation.layout.Arrangement.Center
    ) {
        Text(
            text = "+$count",
            color = Color.White
        )
    }
}


@Preview(showBackground = true)
@Composable
fun RelatedBooksItemsPreview() {
    RelatedBooksItem(
        relatedBooks = listOf(
            RelatedBooks("1", "Book 1", "https://example.com/1.jpg"),
            RelatedBooks("2", "Book 2", "https://example.com/2.jpg"),
            RelatedBooks("3", "Book 3", "https://example.com/3.jpg"),
            RelatedBooks("4", "Book 4", "https://example.com/4.jpg"),
            RelatedBooks("5", "Book 5", "https://example.com/5.jpg"),
        )
        , onClick = {}
    )
}