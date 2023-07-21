package ui.home

import androidx.compose.runtime.Composable

@Composable
fun HomeScreen(logout: () -> Unit) {
    HomeComponent(logout)
}