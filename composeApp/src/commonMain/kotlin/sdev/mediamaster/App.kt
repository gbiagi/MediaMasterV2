package sdev.mediamaster

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import org.jetbrains.compose.ui.tooling.preview.Preview
import sdev.mediamaster.screens.LoginScreen
import sdev.mediamaster.screens.MainScreen
import sdev.mediamaster.screens.RegisterScreen
import sdev.mediamaster.screens.ListView
import sdev.mediamaster.itemClasses.Item
import sdev.mediamaster.itemClasses.Book
import sdev.mediamaster.screens.SearchScreen

// Paleta de colores personalizada
private val DarkGreen = Color(0xFF145A32)
private val White = Color(0xFFFFFFFF)
private val Grey = Color(0xFF232323)

private val CustomDarkColorScheme = darkColorScheme(
    primary = White,
    onPrimary = DarkGreen,
    background = DarkGreen,
    onBackground = White,
    surface = DarkGreen,
    onSurface = White,
    secondary = White,
    onSecondary = DarkGreen,
    inversePrimary = Grey
)

@Composable
fun MediaMasterTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = CustomDarkColorScheme,
        typography = Typography(),
        content = content
    )
}

// Enum para navegación
enum class NavigationTarget {
    LOGIN, REGISTER, MAIN, SEARCH
}

@Composable
@Preview
fun App() {
    MediaMasterTheme {
        var navigation by remember { mutableStateOf(NavigationTarget.LOGIN) }

        when (navigation) {
            NavigationTarget.LOGIN -> {
                LoginScreen(
                    onLoginSuccess = { navigation = NavigationTarget.MAIN },
                    onRegisterClick = { navigation = NavigationTarget.REGISTER }
                )
            }

            NavigationTarget.REGISTER -> {
                RegisterScreen(goBack = { navigation = NavigationTarget.LOGIN })
            }

            NavigationTarget.MAIN -> {
                MainScreen(
                    goTo = { navigation = it }
                )
            }

            NavigationTarget.SEARCH -> {
                SearchScreen(goTo = { navigation = it })
            }
        }
    }
}
