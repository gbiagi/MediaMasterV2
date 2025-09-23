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
import sdev.mediamaster.itemClasses.Game

@Composable
fun GameComponent(game: Game, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = game.title, style = MaterialTheme.typography.titleMedium)
            Text(text = "Plataforma: ${game.platform}", style = MaterialTheme.typography.bodyMedium)
            game.genre?.let {
                Text(text = "Género: $it", style = MaterialTheme.typography.bodyMedium)
            }
            game.developer?.let {
                Text(text = "Desarrollador: $it", style = MaterialTheme.typography.bodyMedium)
            }
            Text(text = "Año: ${game.releaseYear}", style = MaterialTheme.typography.bodySmall)
            Text(text = game.description, style = MaterialTheme.typography.bodySmall)
        }
    }
}