package sdev.mediamaster.screens

import Appbar
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import sdev.mediamaster.NavigationTarget
import sdev.mediamaster.itemClasses.Book
import sdev.mediamaster.itemClasses.Item
import sdev.mediamaster.components.BookComponent
import sdev.mediamaster.components.ListComponent

@Composable
fun MainScreen(
    listsItems: List<Item>,
    onListEdit: (String, List<Item>) -> Unit,
    goTo: (NavigationTarget) -> Unit
) {
    Column {
        Appbar("Main Screen", goTo)
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
                Button(onClick = {
                    goTo(NavigationTarget.SEARCH)
                }) {
                    Text("Search")
                }
                ListComponent(
                    title = "Libros Recomendados 1",
                    items = listsItems,
                    onEdit = onListEdit
                )
                ListComponent(
                    title = "Libros Recomendados 2",
                    items = listsItems,
                    onEdit = onListEdit
                )
                ListComponent(
                    title = "Libros Recomendados 3",
                    items = listsItems,
                    onEdit = onListEdit
                )
                ListComponent(
                    title = "Libros Recomendados 4",
                    items = listsItems,
                    onEdit = onListEdit
                )
                ListComponent(
                    title = "Libros Recomendados 5",
                    items = listsItems,
                    onEdit = onListEdit
                )
            }
        }
    }
}
