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
import sdev.mediamaster.itemClasses.TV

@Composable
fun TVComponent(tv: TV, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = tv.title, style = MaterialTheme.typography.titleMedium)
            Text(text = "Año: ${tv.firstAirDate}", style = MaterialTheme.typography.bodySmall)
            Text(text = tv.description, style = MaterialTheme.typography.bodySmall)
        }
    }
}