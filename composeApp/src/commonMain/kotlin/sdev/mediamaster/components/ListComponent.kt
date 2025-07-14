package sdev.mediamaster.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import sdev.mediamaster.itemClasses.*
import sdev.mediamaster.screens.ListView

@Composable
fun ListComponent(
    title: String,
    items: List<Item>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Row {
            Text(
                text = title,
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            )
            Button(onClick = {
                // Go to list view

            }) {
                Text("Edit")
            }
        }
        HorizontalDivider(
            modifier = Modifier.padding(horizontal = 16.dp),
            thickness = 1.dp,
            color = MaterialTheme.colorScheme.outline
        )

        // Horizontal list of items
        LazyRow(
            modifier = Modifier.padding(top = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(items.size) { index ->
                ItemDisplay(item = items[index])
            }
        }
    }
}


@Composable
private fun ItemDisplay(item: Item) {
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