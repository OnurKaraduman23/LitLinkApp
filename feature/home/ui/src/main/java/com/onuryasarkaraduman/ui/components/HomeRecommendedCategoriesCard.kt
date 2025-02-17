package com.onuryasarkaraduman.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.onuryasarkaraduman.core.ui.R
import com.onuryasarkaraduman.domain.model.CategoriesRecommendedModel


@Composable
fun HomeRecommendedCategoriesCard(
    modifier: Modifier = Modifier,
    book: CategoriesRecommendedModel,
    onClick: () -> Unit,
) {
    Card(
        modifier = modifier.padding(8.dp)
            .size(width = 150.dp, height = 250.dp),
        elevation = CardDefaults.cardElevation(16.dp),
        border = BorderStroke(
            width = 2.dp,
            color = colorResource(id = R.color.yellow)
        ),
        onClick = { onClick() },

        ) {
        Column(
            modifier = Modifier
                .padding(8.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            AppAsyncImage(
                imageUrl = book.bookUrl,
            )

            Spacer(modifier = Modifier.height(8.dp))
            Text(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                text = book.bookName,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )

            Column(
                modifier = Modifier
                    .width(90.dp)
                    .align(Alignment.Start),


            ){
                CategoriesComponent(
                    categoryText = book.category
                )
            }


        }

    }

}

@Preview(showBackground = true)
@Composable
fun HomeRecommendedBooksCardPreview() {
    HomeRecommendedCategoriesCard(
        book = CategoriesRecommendedModel(
            id = "asf",
            bookName = "Dante's Inferno,Dante's Inferno,Dante's Inferno,Dante's Inferno,Dante's Inferno",
            bookUrl = "Image",
            category = "fiction / science"
        ),
        onClick = {}
    )
}