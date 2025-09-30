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
import sdev.mediamaster.Screen


@Composable
fun MainScreen(
    goTo: (Screen) -> Unit
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
                // Show list from user

            }
        }
    }
}
