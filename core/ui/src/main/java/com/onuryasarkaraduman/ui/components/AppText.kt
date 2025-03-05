package com.onuryasarkaraduman.ui.components


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun HeaderText(
    modifier: Modifier = Modifier,
    text: String,
    fontSize: Int = 22,
    fontWeight: FontWeight = FontWeight.Bold,
    color: Color = Color.Black,
    overflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE,
    textAlign: TextAlign? = null,
) {
    val capitalizedText = text.split(" ").joinToString(" ") {
        it.replaceFirstChar { c -> c.uppercaseChar() }
    }

    Text(
        modifier = modifier,
        text = capitalizedText,
        color = color,
        fontSize = fontSize.sp,
        fontWeight = fontWeight,
        overflow = overflow,
        maxLines = maxLines,
        textAlign = textAlign
    )

}

@Composable
fun AppText(
    modifier: Modifier = Modifier,
    text: String,
    fontSize: Int = 14,
    color: Color = Color.Black,
    overflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE,
    textAlign: TextAlign? = null,
) {


    Text(
        modifier = modifier,
        text = text,
        color = color,
        fontSize = fontSize.sp,
        overflow = overflow,
        maxLines = maxLines,
        textAlign = textAlign
    )

}

@Composable
fun AppTextTitle(
    modifier: Modifier = Modifier,
    text: String,
    fontSize: Int = 18,
    color: Color = Color.Black,
    fontWeight: FontWeight = FontWeight.Bold,
    overflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE,
    textAlign: TextAlign? = null,
) {


    Text(
        modifier = modifier,
        text = text,
        color = color,
        fontSize = fontSize.sp,
        fontWeight = fontWeight,
        overflow = overflow,
        maxLines = maxLines,
        textAlign = textAlign
    )

}

@Composable
fun WarningTextMessage(warningMessage: String) {
    Text(
        text = warningMessage,
        color = Color.Red,
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold
    )
}

@Preview(showBackground = true)
@Composable
fun HeaderTextPreview() {

    HeaderText(
        text = "litLinkApp header"
    )
}

@Preview(showBackground = true)
@Composable
fun AppTextPreview() {

    AppText(
        text = "AppText"
    )
}
@Preview(showBackground = true)
@Composable
fun AppTextTitlePreview() {

    AppTextTitle(
        text = "AppText"
    )
}
@Preview(showBackground = true)
@Composable
fun WarningTextMessagePreview() {

    WarningTextMessage(
        warningMessage = "Warning"
    )
}