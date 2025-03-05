package com.onuryasarkaraduman.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.onuryasarkaraduman.core.ui.R
import com.onuryasarkaraduman.ui.RegisterContract.UiAction
import com.onuryasarkaraduman.ui.RegisterContract.UiEffect
import com.onuryasarkaraduman.ui.RegisterContract.UiState
import com.onuryasarkaraduman.ui.components.AppToolbar
import com.onuryasarkaraduman.ui.components.WarningTextMessage
import com.onuryasarkaraduman.ui.extensions.collectWithLifecycle
import kotlinx.coroutines.flow.Flow


@Composable
internal fun RegisterScreen(
    uiState: UiState,
    uiEffect: Flow<UiEffect>,
    onAction: (UiAction) -> Unit,
    onNavigateBack: () -> Unit,
    onNavigateHome: () -> Unit,
    onNavigateLogin: () -> Unit,
) {

    uiEffect.collectWithLifecycle { effect ->
        when (effect) {
            UiEffect.NavigateBack -> onNavigateBack()
            UiEffect.NavigateHome -> onNavigateHome()
            UiEffect.NavigateLogin -> onNavigateLogin()
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

        RegisterContent(
            uiState = uiState,
            onEmailChange = { onAction(UiAction.OnEmailChange(it)) },
            onPasswordChange = { onAction(UiAction.OnPasswordChange(it)) },
            onPasswordAgainChange = { onAction(UiAction.OnPasswordAgainChange(it)) },
            onUserNameChange = { onAction(UiAction.OnUsernameChange(it)) },
            onRegisterClick = { onAction(UiAction.OnRegisterClick) },
            onLoginClick = { onAction(UiAction.OnLoginClick) }
        )
    }

}

@Composable
internal fun RegisterContent(
    uiState: UiState,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onPasswordAgainChange: (String) -> Unit,
    onUserNameChange: (String) -> Unit,
    onRegisterClick: () -> Unit,
    onLoginClick: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        EmailPasswordAndUserNameContent(
            email = uiState.email,
            password = uiState.password,
            passwordAgain = uiState.passwordAgain,
            userName = uiState.username,
            warningMessage = if (uiState.password != uiState.passwordAgain) stringResource(id = R.string.passwords_do_not_match) else null,
            onEmailChange = { onEmailChange(it) },
            onUserNameChange = { onUserNameChange(it) },
            onPasswordChange = { onPasswordChange(it) },
            onConfirmPasswordChange = { onPasswordAgainChange(it) },
            onRegisterClick = { onRegisterClick() },
        )
    }


}

@Composable
fun EmailPasswordAndUserNameContent(
    email: String,
    password: String,
    userName: String,
    passwordAgain: String,
    warningMessage: String?,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onUserNameChange: (String) -> Unit,
    onConfirmPasswordChange: (String) -> Unit,
    onRegisterClick: () -> Unit,
) {
    var passwordVisibility by remember { mutableStateOf(false) }
    var confirmPasswordVisibility by remember { mutableStateOf(false) }

    Text(text = "Sign Up", fontWeight = FontWeight.Bold, fontSize = 24.sp)
    Spacer(modifier = Modifier.height(32.dp))

    OutlinedTextField(
        value = userName,
        maxLines = 1,
        placeholder = { Text(text = "Username") },
        onValueChange = { input ->
            val formattedInput = input.replaceFirstChar {
                if (it.isLowerCase()) it.titlecase() else it.toString()
            }
            onUserNameChange(formattedInput)
        }
    )

    Spacer(modifier = Modifier.height(32.dp))

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

    if (warningMessage != null) {
        WarningTextMessage(warningMessage = warningMessage)
    }

    OutlinedTextField(
        value = passwordAgain,
        singleLine = true,
        placeholder = { Text(text = "Confirm Password") },
        onValueChange = onConfirmPasswordChange,
        visualTransformation = if (confirmPasswordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            val imageRes = if (confirmPasswordVisibility) {
                R.drawable.ic_visibility
            } else {
                R.drawable.ic_visibility_off
            }
            val description = if (confirmPasswordVisibility) "Hide password" else "Show password"

            IconButton(onClick = { confirmPasswordVisibility = !confirmPasswordVisibility }) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = imageRes),
                    contentDescription = description
                )
            }
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
    )

    Spacer(modifier = Modifier.height(32.dp))

    Button(onClick = onRegisterClick) {
        Text(text = "Sign Up")
    }
}