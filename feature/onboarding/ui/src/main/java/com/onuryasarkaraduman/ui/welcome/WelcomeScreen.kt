package com.onuryasarkaraduman.ui.welcome

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.onuryasarkaraduman.ui.components.BackgroundImage
import com.onuryasarkaraduman.ui.components.NextButton
import com.onuryasarkaraduman.core.ui.R

@Composable
fun WelcomeScreen(
    modifier: Modifier = Modifier,
    onNavigateCategoriesSelector:() -> Unit
) {
    Box(modifier = modifier.fillMaxSize()) {

        BackgroundImage(
            drawableResId = R.drawable.onboarding_welcome_background,
            transparency = 0.9f
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(
                modifier = Modifier
                    .background(color = colorResource(id = R.color.gray_transparent)),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    modifier = Modifier.padding(16.dp),
                    text = stringResource(id = R.string.onboarding_welcome),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic
                )
            }

            Spacer(modifier = Modifier.height(8.dp))
            NextButton(
                text = stringResource(id = R.string.next),
                textColor = Color.Black,
                onClick = {onNavigateCategoriesSelector()}
            )


        }
    }
}