package sdev.mediamaster.screens

import Appbar
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import sdev.mediamaster.itemClasses.Book
import sdev.mediamaster.itemClasses.Item
import sdev.mediamaster.components.BookComponent
import sdev.mediamaster.components.ListComponent

@Composable
fun MainScreen() {
    val listsItems = remember { mutableStateListOf<Item>() }
    // Inicializar la lista con algunos libros de ejemplo
    if (listsItems.isEmpty()) {
        listsItems.add(
            Book(
                "Book 1",
                "Author 1",
                2023,
                "https://ichef.bbci.co.uk/news/1024/cpsprodpb/EF37/production/_108993216_ok-hand.jpg.webp",
                "Description of Book 1"
            )
        )
        listsItems.add(
            Book(
                "Book 2",
                "Author 2",
                2022,
                "https://ichef.bbci.co.uk/news/1024/cpsprodpb/EF37/production/_108993216_ok-hand.jpg.webp",
                "Description of Book 2"
            )
        )
    }

    Column {
        Appbar("Main Screen")
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background), // Usa el color de fondo del tema
            contentAlignment = Alignment.TopCenter
        ) {
            Column(
                modifier = Modifier.verticalScroll(rememberScrollState())
            ) {
                Button(onClick = {
                    println("List Items: ${listsItems.size}")
                }) {
                    Text("Add Item")
                }

                ListComponent(
                    title = "Libros Recomendados 1",
                    items = listsItems
                )
                ListComponent(
                    title = "Libros Recomendados 2",
                    items = listsItems
                )
                ListComponent(
                    title = "Libros Recomendados 3",
                    items = listsItems
                )
                ListComponent(
                    title = "Libros Recomendados 4",
                    items = listsItems
                )
                ListComponent(
                    title = "Libros Recomendados 5",
                    items = listsItems
                )
            }
        }
    }
}
