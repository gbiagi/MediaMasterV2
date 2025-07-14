package sdev.mediamaster.screens

import Appbar
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import sdev.mediamaster.itemClasses.Item

// Detailed view of the lists
@Composable
fun ListView(
    title: String,
    items: List<Item>
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Appbar(title)
        // Display each item in the list
        items.forEach { item ->
            Text(
                text = item.name,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            )
            // Here you can add more details about the item if needed
            // For example, you could show a description or other properties
        }
    }
}