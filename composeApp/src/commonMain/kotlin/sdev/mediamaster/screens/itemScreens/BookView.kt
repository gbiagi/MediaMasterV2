package sdev.mediamaster.screens.itemScreens

import Appbar
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
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
import sdev.mediamaster.Screen
import sdev.mediamaster.itemClasses.Book
import sdev.mediamaster.itemClasses.Movie
import sdev.mediamaster.network.ApiClient

@Composable
fun BookView(id: String, goTo: (Screen) -> Unit) {
    var displayedBook by remember { mutableStateOf<Book?>(null) }
    var isLoading by remember { mutableStateOf(true) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(id) {
        try {
            displayedBook = ApiClient.getBook(id)
            isLoading = false
        } catch (e: Exception) {
            errorMessage = "Error loading movie: ${e.message}"
            isLoading = false
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
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

            displayedBook != null -> {
                Column(
                    modifier = Modifier.padding(vertical = 30.dp, horizontal = 250.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    KamelImage(
                        resource = asyncPainterResource(displayedBook!!.imgFullUrl),
                        contentDescription = "imgposter",
                        modifier = Modifier
                            .size(300.dp)
                            .padding(4.dp)
                            .border(width = 2.dp, color = MaterialTheme.colorScheme.inversePrimary),
                        contentScale = ContentScale.Crop
                    )
                    Text(text = displayedBook!!.title, style = MaterialTheme.typography.headlineMedium)
                    Spacer(Modifier.height(8.dp))
                    Text(text = displayedBook!!.description)
                    Spacer(Modifier.height(8.dp))
                }
            }
        }
    }
}