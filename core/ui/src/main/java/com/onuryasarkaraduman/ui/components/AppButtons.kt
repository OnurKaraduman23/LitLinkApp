package com.onuryasarkaraduman.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.onuryasarkaraduman.core.ui.R

@Composable
fun AddFriendsButton(
    modifier: Modifier = Modifier,
    text: String,
    onClickAddFriends: () -> Unit,
) {
    Button(
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(id = R.color.yellow)
        ),
        onClick = { onClickAddFriends() }
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Icon Button"
        )
        Text(text = text, fontSize = 16.sp)
    }
}

@Composable
fun CutCornerButton(
    text: String,
    textColor: Color = Color.Black,
    textFontWeight: FontWeight = FontWeight.Bold,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true,
    textStyle: TextStyle = MaterialTheme.typography.bodyLarge,
) {
    OutlinedButton(
        modifier = modifier
            .fillMaxWidth()
            .padding(26.dp),
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(id = R.color.yellow),
            contentColor = Color.Red,
            disabledContainerColor = Color.Gray,
            disabledContentColor = Color.Black
        ),
        enabled = isEnabled,
        shape = CutCornerShape(12.dp),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 8.dp,
            pressedElevation = 24.dp,
            disabledElevation = 8.dp
        ),
    ) {
        Text(
            text = text,
            style = textStyle,
            color = textColor,
            fontWeight = textFontWeight
        )
    }
}

@Composable
fun GlowingButton(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color = Color.Black,
    textFontWeight: FontWeight = FontWeight.Bold,
    onClick: () -> Unit,
    isEnabled: Boolean = true,
    textStyle: TextStyle = MaterialTheme.typography.bodyLarge,
) {
    GlowingCard(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        glowingColor = colorResource(id = R.color.green),
        cardRadius = 28.dp
    ) {
        Button(
            modifier = modifier.fillMaxSize(),
            enabled = isEnabled,
            onClick = { onClick() },
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.yellow)
            ),

            ) {
            Text(text = text, color = textColor, fontWeight = textFontWeight, style = textStyle)
        }
    }

}

@Composable
fun LitLinkAppButton(
    text: String,
    textColor: Color = Color.Black,
    textFontWeight: FontWeight = FontWeight.Bold,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true,
    textStyle: TextStyle = MaterialTheme.typography.bodyLarge,
) {
    OutlinedButton(
        modifier = modifier
            .fillMaxWidth()
            .padding(26.dp),
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(id = R.color.yellow),
            contentColor = Color.Red,
            disabledContainerColor = Color.Gray,
            disabledContentColor = Color.Black
        ),
        enabled = isEnabled,
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 8.dp,
            pressedElevation = 24.dp,
            disabledElevation = 8.dp
        ),
    ) {
        Text(
            text = text,
            style = textStyle,
            color = textColor,
            fontWeight = textFontWeight
        )
    }
}




@Preview(showBackground = true)
@Composable
fun AddFriendsButtonPreview() {
    AddFriendsButton(
        text = stringResource(id = R.string.add_friends),
        onClickAddFriends = {}
    )
}


@Preview(showBackground = true)
@Composable
fun CutCornerButtonPreview() {
    CutCornerButton(
        text = stringResource(id = R.string.next),
        textColor = Color.Black,
        onClick = {}
    )
}

@Preview(showBackground = true)
@Composable
fun UpgrageButtonPreview() {
    Box(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        contentAlignment = Alignment.Center,
    ) {
        GlowingButton(
            text = "Upgrade",
            onClick = {}
        )
    }

}
@Preview(showBackground = true)
@Composable
fun LitLinkAppButtonPreview() {
    LitLinkAppButton(
        text = stringResource(id = R.string.add_other_categories),
        textColor = Color.Black,
        onClick = {}
    )
}

