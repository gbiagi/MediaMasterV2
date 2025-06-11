package sdev.mediamaster.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun MainScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background), // Usa el color de fondo del tema
        contentAlignment = Alignment.Center
    ) {
        Text("¡Bienvenido a la pantalla principal!")
    }
}