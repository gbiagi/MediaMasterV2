package sdev.mediamaster.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import sdev.mediamaster.itemClasses.Book
import sdev.mediamaster.itemClasses.Game
import sdev.mediamaster.itemClasses.Item
import sdev.mediamaster.itemClasses.Movie

@Composable
fun ItemDisplay(item: Item) {
    when (item) {
        is Book -> BookComponent(book = item)
        is Movie -> MovieComponent(movie = item)
        is Game -> GameComponent(game = item)
        else -> Text(
            text = item.name,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(8.dp)
        )
    }
}