package sdev.mediamaster.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import sdev.mediamaster.itemClasses.*

@Composable
fun BookComponent(book: Book, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = book.title, style = MaterialTheme.typography.titleMedium)
            Text(text = "Autor: ${book.author}", style = MaterialTheme.typography.bodyMedium)
            Text(text = book.description, style = MaterialTheme.typography.bodySmall)
        }
    }
}




