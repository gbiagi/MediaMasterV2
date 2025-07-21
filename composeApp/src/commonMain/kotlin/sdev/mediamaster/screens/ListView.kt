package sdev.mediamaster.screens

import Appbar
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import sdev.mediamaster.App
import sdev.mediamaster.NavigationTarget
import sdev.mediamaster.components.ItemDisplay
import sdev.mediamaster.itemClasses.Item

// Detailed view of the lists
@Composable
fun ListView(
    title: String,
    items: List<Item>,
    goTo: (NavigationTarget) -> Unit
) {
    Column {
        Appbar(title, goTo)
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background), // Usa el color de fondo del tema
            contentAlignment = Alignment.TopCenter
        ) {
            Column(
                modifier = Modifier.verticalScroll(rememberScrollState())
            ) {
                // Display each item in the list
                items.forEach { item ->
                    ItemDisplay(item = item)
                }
            }
        }
    }
}