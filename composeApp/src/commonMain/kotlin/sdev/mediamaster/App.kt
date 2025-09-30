package sdev.mediamaster

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import org.jetbrains.compose.ui.tooling.preview.Preview
import sdev.mediamaster.screens.LoginScreen
import sdev.mediamaster.screens.MainScreen
import sdev.mediamaster.screens.RegisterScreen
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

// Reemplazamos el enum por un sealed class que permite parámetros para destinos con payload.
sealed class Screen {
    object Login : Screen()
    object Register : Screen()
    object Main : Screen()
    object Search : Screen()
    data class MovieDetail(val id: String) : Screen()
    data class BookDetail(val id: String) : Screen()
    data class GameDetail(val id: String) : Screen()
    data class TVDetail(val id: String) : Screen()
    object Back : Screen() // usar para indicar "volver"
    // agrega más destinos con parámetros si los necesitas
}

@Composable
@Preview
fun App() {
    MediaMasterTheme {
        // Stack simple de navegación
        val backStack = remember { mutableStateListOf<Screen>(Screen.Login) }

        // navigate: push o pop si se pasa Screen.Back
        val navigate: (Screen) -> Unit = { s ->
            if (s == Screen.Back) {
                if (backStack.size > 1) backStack.removeAt(backStack.lastIndex)
            } else {
                backStack.add(s)
            }
        }

        when (val current = backStack.last()) {
            is Screen.Login -> {
                LoginScreen(
                    onLoginSuccess = { navigate(Screen.Main) },
                    onRegisterClick = { navigate(Screen.Register) }
                )
            }

            is Screen.Register -> {
                RegisterScreen(goBack = { navigate(Screen.Login) })
            }

            is Screen.Main -> {
                // Pasamos la función navigate a MainScreen para que pueda enviar pantallas con parámetros
                MainScreen(
                    goTo = navigate
                )
            }

            is Screen.Search -> {
                // Pasamos navigate para que SearchScreen pueda navegar a MovieDetail/BookDetail, etc.
                SearchScreen(onNavigate = navigate)
            }

            is Screen.MovieDetail -> {
                // Mostrar MovieView y permitir navegar o volver
                sdev.mediamaster.screens.itemScreens.MovieView(
                    id = current.id,
                    goTo = navigate
                )
            }

            is Screen.BookDetail -> {
                sdev.mediamaster.screens.itemScreens.BookView(
                    id = current.id,
                    goTo = navigate
                )
            }

            is Screen.GameDetail -> {
                sdev.mediamaster.screens.itemScreens.GameView(
                    id = current.id,
                    goTo = navigate
                )
            }

            is Screen.TVDetail -> {
                sdev.mediamaster.screens.itemScreens.TVView(
                    id = current.id,
                    goTo = navigate
                )
            }

            else -> {}
        }
    }
}
