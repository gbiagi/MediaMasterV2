package sdev.mediamaster

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import org.jetbrains.compose.ui.tooling.preview.Preview
import sdev.mediamaster.screens.LoginScreen
import sdev.mediamaster.screens.MainScreen

// Paleta de colores personalizada
private val DarkGreen = Color(0xFF145A32)
private val White = Color(0xFFFFFFFF)

private val CustomDarkColorScheme = darkColorScheme(
    primary = White,
    onPrimary = DarkGreen,
    background = DarkGreen,
    onBackground = White,
    surface = DarkGreen,
    onSurface = White,
    secondary = White,
    onSecondary = DarkGreen
)

@Composable
fun MediaMasterTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = CustomDarkColorScheme,
        typography = Typography(),
        content = content
    )
}

@Composable
@Preview
fun App() {
    MediaMasterTheme {
        var loggedIn by remember { mutableStateOf(false) }
        if (!loggedIn) {
            LoginScreen(onLoginSuccess = { loggedIn = true })
        } else {
            MainScreen()
        }
    }
}
