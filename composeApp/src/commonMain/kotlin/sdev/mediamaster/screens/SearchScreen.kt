package sdev.mediamaster.screens

import Appbar
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import androidx.compose.ui.layout.ContentScale
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.material3.*
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import kotlinx.coroutines.launch
import sdev.mediamaster.Screen
import sdev.mediamaster.itemClasses.Item
import sdev.mediamaster.itemClasses.ItemSearch
import sdev.mediamaster.network.ApiClient
import sdev.mediamaster.screens.itemScreens.MovieView

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    onNavigate: (Screen) -> Unit
) {
    var search by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    var showSuggestions by remember { mutableStateOf(false) }
    val options = listOf("Movie", "TV", "Game", "Book")
    var selectedOption by remember { mutableStateOf(options[0]) }
    var suggestionItems by remember { mutableStateOf(listOf<ItemSearch>()) }

    val coroutineScope = rememberCoroutineScope()

    Column() {
        Appbar("Search", onNavigate)
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.TopCenter
        ) {
            Column(
                modifier = Modifier.verticalScroll(rememberScrollState())
            ) {
                Spacer(Modifier.height(10.dp))
                Box {
                    Row() {
                        // Search bar
                        OutlinedTextField(
                            value = search,
                            onValueChange = { search = it },
                            singleLine = true,
                            modifier = Modifier.size(width = 500.dp, height = 56.dp),
                            colors = TextFieldDefaults.colors(
                                focusedTextColor = MaterialTheme.colorScheme.primary,
                                unfocusedTextColor = MaterialTheme.colorScheme.primary,

                                ),
                            leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "") },
                            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                            keyboardActions = KeyboardActions(
                                onSearch = {
                                    coroutineScope.launch {
                                        suggestionItems = ApiClient.search(selectedOption, search)
                                    }
                                    showSuggestions = true
                                }
                            )
                        )

                        // Category selection
                        ExposedDropdownMenuBox(
                            expanded = expanded,
                            onExpandedChange = { expanded = !expanded }
                        ) {
                            OutlinedTextField(
                                value = selectedOption,
                                onValueChange = {},
                                readOnly = true,
                                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                                colors = TextFieldDefaults.colors(
                                    focusedTextColor = MaterialTheme.colorScheme.inversePrimary,
                                    unfocusedTextColor = MaterialTheme.colorScheme.inversePrimary,
                                    focusedContainerColor = MaterialTheme.colorScheme.primary,
                                    unfocusedContainerColor = MaterialTheme.colorScheme.primary,
                                    focusedIndicatorColor = MaterialTheme.colorScheme.outline,
                                    unfocusedIndicatorColor = MaterialTheme.colorScheme.outline
                                ),
                                modifier = Modifier
                                    .menuAnchor()
                                    .width(150.dp)
                                    .height(56.dp),
                            )
                            ExposedDropdownMenu(
                                expanded = expanded,
                                onDismissRequest = { expanded = false }
                            ) {
                                options.forEach { selectionOption ->
                                    DropdownMenuItem(
                                        text = { Text(selectionOption) },
                                        onClick = {
                                            selectedOption = selectionOption
                                            expanded = false
                                        }
                                    )
                                }
                            }
                        }
                    }
                    // Suggestions dropdown
                    if (showSuggestions && search.isNotEmpty()) {
                        Card(
                            modifier = Modifier
                                .width(500.dp)
                                .padding(top = 56.dp),
                            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
                        ) {
                            Column {
                                suggestionItems.forEach { item ->
                                    DropdownMenuItem(
                                        text = {
                                            Row(verticalAlignment = Alignment.CenterVertically) {
                                                KamelImage(
                                                    resource = asyncPainterResource(item.imageUrl),
                                                    contentDescription = item.displayTitle,
                                                    modifier = Modifier
                                                        .size(80.dp)
                                                        .padding(4.dp),
                                                    contentScale = ContentScale.Crop
                                                )
                                                Spacer(modifier = Modifier.width(8.dp))
                                                Text(item.displayTitle)
                                            }
                                        },
                                        onClick = {
                                            showSuggestions = false
                                            // Usar el ID real del item
                                            val itemId = item.id?.toString() ?: "0"
                                            when (selectedOption) {
                                                "Movie" -> onNavigate(Screen.MovieDetail(itemId))
                                                "Book" -> onNavigate(Screen.BookDetail(itemId))
                                                "Game" -> onNavigate(Screen.GameDetail(itemId))
                                                "TV" -> onNavigate(Screen.TVDetail(itemId))
                                                else -> {}
                                            }
                                        },
                                        modifier = Modifier.fillMaxWidth()
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
