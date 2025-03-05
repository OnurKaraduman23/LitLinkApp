package com.onuryasarkaraduman.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.onuryasarkaraduman.core.ui.R
import com.onuryasarkaraduman.ui.LoginContract.UiAction
import com.onuryasarkaraduman.ui.LoginContract.UiEffect
import com.onuryasarkaraduman.ui.LoginContract.UiState
import com.onuryasarkaraduman.ui.components.AppToolbar
import com.onuryasarkaraduman.ui.extensions.collectWithLifecycle
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

@Composable
internal fun LoginScreen(
    uiState: UiState,
    uiEffect: Flow<UiEffect>,
    onAction: (UiAction) -> Unit,
    onNavigateBack: () -> Unit,
    onNavigateRegister: () -> Unit,
    onNavigateHome: () -> Unit,
) {

    uiEffect.collectWithLifecycle { effect ->
        when (effect) {
            UiEffect.NavigateBack -> {}
            UiEffect.NavigateHome -> onNavigateHome()
            UiEffect.NavigateRegister -> onNavigateRegister()
        }

    }
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        AppToolbar(
            onBackClick = { onAction(UiAction.OnBackClick) },
        )
        LoginContent(
            uiState = uiState,
            onEmailChange = { onAction(UiAction.OnEmailChange(it)) },
            onPasswordChange = { onAction(UiAction.OnPasswordChange(it)) },
            onRegisterClick = { onAction(UiAction.OnRegisterClick) },
            onLoginClick = { onAction(UiAction.OnLoginClick) }
        )
    }
}

@Composable
internal fun LoginContent(
    uiState: UiState,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onRegisterClick: () -> Unit,
    onLoginClick: () -> Unit,
) {
    EmailAndPasswordContent(
        email = uiState.email,
        password = uiState.password,
        onEmailChange = { onEmailChange(it) },
        onPasswordChange = { onPasswordChange(it) },
        onLogInClick = { onLoginClick() },
        onRegisterClick = { onRegisterClick() }
    )
}

@Composable
internal fun EmailAndPasswordContent(
    email: String,
    password: String,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onLogInClick: () -> Unit,
    onRegisterClick: () -> Unit,
) {
    var passwordVisibility by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = email,
        maxLines = 1,
        placeholder = { Text(text = "Email") },
        onValueChange = onEmailChange
    )
    Spacer(modifier = Modifier.height(16.dp))

    OutlinedTextField(
        value = password,
        onValueChange = onPasswordChange,
        label = { Text("Password") },
        singleLine = true,
        placeholder = { Text("Enter your password") },
        visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            val imageRes = if (passwordVisibility) {
                R.drawable.ic_visibility
            } else {
                R.drawable.ic_visibility_off
            }
            val description = if (passwordVisibility) "Hide password" else "Show password"

            IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = imageRes),
                    contentDescription = description
                )
            }
        }
    )

    Spacer(modifier = Modifier.height(16.dp))

    Row(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 64.dp),
        horizontalArrangement = Arrangement.End
    ) {
        Text(text = "Forgot Password?", color = colorResource(id = R.color.gray_transparent))
    }

    Spacer(modifier = Modifier.height(16.dp))


    Button(onClick = { onRegisterClick() }) {
        Text(text = "Register")
    }
    Spacer(modifier = Modifier.height(16.dp))

    Button(onClick = onLogInClick) {
        Text(text = "Log In")
    }


}

@Preview(showBackground = true)
@Composable
internal fun LoginScreenPreview() {
    LoginScreen(
        uiState = UiState(),
        uiEffect = flow { },
        onAction = {},
        onNavigateBack = {},
        onNavigateHome = {},
        onNavigateRegister = {}
    )
}