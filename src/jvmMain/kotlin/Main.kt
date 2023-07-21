import androidx.compose.material.MaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import ui.home.HomeScreen
import ui.login.LoginScreen
import util.WindowType

@Composable
@Preview
fun App() {
    var screen by remember { mutableStateOf(WindowType.LOGIN) }
    MaterialTheme {
        when (screen) {
            WindowType.LOGIN -> LoginScreen { screen = WindowType.HOME }
            WindowType.HOME -> HomeScreen {screen = WindowType.LOGIN}
        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication, state = rememberWindowState(size = DpSize(700.dp, 450.dp))) {
        App()
    }
}
