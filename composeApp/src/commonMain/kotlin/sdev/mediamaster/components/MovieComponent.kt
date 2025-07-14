package sdev.mediamaster.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import sdev.mediamaster.itemClasses.Movie

@Composable
fun MovieComponent(movie: Movie, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = movie.name, style = MaterialTheme.typography.titleMedium)
            Text(text = "Director: ${movie.director}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Año: ${movie.releaseYear}", style = MaterialTheme.typography.bodySmall)
            Text(text = movie.description, style = MaterialTheme.typography.bodySmall)
        }
    }
}