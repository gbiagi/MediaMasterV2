package sdev.mediamaster.screens.itemScreens

import Appbar
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import sdev.mediamaster.Screen
import sdev.mediamaster.itemClasses.Movie
import sdev.mediamaster.network.ApiClient
@Preview
@Composable
fun MovieView(id: String, goTo: (Screen) -> Unit) {
    var displayedMovie by remember { mutableStateOf<Movie?>(null) }
    var isLoading by remember { mutableStateOf(true) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(id) {
        try {
            displayedMovie = ApiClient.getMovie(id)
            isLoading = false
        } catch (e: Exception) {
            errorMessage = "Error loading movie: ${e.message}"
            isLoading = false
        }
    }
    Column {
        Appbar("Movie", goTo)
        Spacer(Modifier.height(10.dp))

        when {
            isLoading -> {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }

            errorMessage != null -> {
                Text(
                    text = errorMessage!!,
                    modifier = Modifier.padding(16.dp)
                )
            }

            displayedMovie != null -> {
                Column(modifier = Modifier.padding(16.dp)) {
                    KamelImage(
                        resource = asyncPainterResource(displayedMovie!!.imgFullUrl),
                        contentDescription = "aaa",
                        modifier = Modifier
                            .size(80.dp)
                            .padding(4.dp),
                        contentScale = ContentScale.Crop
                    )
                    Text(text = "Title: ${displayedMovie!!.title}")
                    Spacer(Modifier.height(8.dp))
                    Text(text = "Description: ${displayedMovie!!.description}")
                    Spacer(Modifier.height(8.dp))
                    Text(text = "Runtime: ${displayedMovie!!.runtime} minutos")
                    Spacer(Modifier.height(8.dp))
                    Text(text = "Release Year: ${displayedMovie!!.releaseYear}")
                }
            }
        }
    }
}