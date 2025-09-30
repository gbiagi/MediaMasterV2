package sdev.mediamaster.screens.itemScreens

import Appbar
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import sdev.mediamaster.Screen

@Composable
fun TVView(id: String, goTo: (Screen) -> Unit) {

    Column {
        Appbar("TV", goTo)
        Spacer(Modifier.height(10.dp))

    }
}