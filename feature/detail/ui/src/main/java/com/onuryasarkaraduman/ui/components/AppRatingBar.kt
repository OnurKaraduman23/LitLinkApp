package com.onuryasarkaraduman.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.onuryasarkaraduman.core.ui.R

@Composable
fun AppRatingBar(
    rating: Float,
    modifier: Modifier = Modifier,
    stars: Int = 5,
    starSize: Dp = 24.dp,
    filledColor: Color = Color(0xFFFFD700), // Altın sarısı
    emptyColor: Color = Color.Gray,
    textColor: Color = Color.Black
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        // Yıldızlar
        for (i in 0 until stars) {
            val starFill = when {
                i + 1 <= rating -> 1f // Tam dolu yıldız
                i < rating -> rating - i // Yarım dolu yıldız
                else -> 0f // Boş yıldız
            }

            Box(modifier = Modifier.size(starSize)) {
                // Boş yıldız (gri)
                Icon(
                    painter = painterResource(id = R.drawable.ic_star),
                    contentDescription = "Empty Star $i",
                    modifier = Modifier.fillMaxSize(),
                    tint = emptyColor
                )
                // Dolu yıldız (sarı) - Yarım doluysa üstüne çiziyoruz
                Icon(
                    painter = painterResource(id = R.drawable.ic_star),
                    contentDescription = "Filled Star $i",
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RectangleShape) // Yarım doluluk için clipping kullanacağız
                        .graphicsLayer {
                            alpha = starFill
                        },
                    tint = filledColor
                )
            }
        }

        // Puanı gösteren metin
        Text(
            text = String.format("%.1f", rating), // 1 ondalık basamak
            fontSize = 16.sp,
            color = textColor,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 4.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AppRatingBarPreview() {
    AppRatingBar(rating = 3.5f)
}

