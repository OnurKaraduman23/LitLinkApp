package com.onuryasarkaraduman.ui.components


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HeaderText(
    modifier: Modifier = Modifier,
    text: String,
    fontSize: Int = 22,
    fontWeight: FontWeight = FontWeight.Bold,
    color: Color = Color.Black,
    overflow: TextOverflow = TextOverflow.Ellipsis,
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
    overflow: TextOverflow = TextOverflow.Ellipsis,
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

@Composable
fun AppAnnotationText(
    normalText: String,
    annotatedText: String,
    onClick: () -> Unit,
    normalTextSize: TextUnit = 12.sp,
    annotatedTextSize: TextUnit = 14.sp
) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontSize = normalTextSize,
                    color = Color.Black
                )
            ) {
                append(normalText)
            }

            append(" ")

            withStyle(
                style = SpanStyle(
                    fontSize = annotatedTextSize,
                    color = Color.Blue,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif,
//                    textDecoration = TextDecoration.Underline
                )
            ) {
                append(annotatedText)
            }
        }
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

@Preview(showBackground = true)
@Composable
fun AppAnnotatedTextPreview() {

    AppAnnotationText(
        normalText = "Normal Text",
        annotatedText = "Annotated Text",
        onClick = {}
    )
}
