package ui.login

import androidx.compose.runtime.Composable

@Composable
fun LoginScreen(navigateToHome : () -> Unit) {
    loginField(navigateToHome)
}