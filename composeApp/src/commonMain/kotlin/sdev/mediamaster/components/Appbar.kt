import sdev.mediamaster.Screen
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton

@Composable
fun Appbar(title: String, goTo: (Screen) -> Unit) {
    Surface(
        shadowElevation = 4.dp,
        shape = RoundedCornerShape(
            bottomStart = 40.dp,
            bottomEnd = 40.dp,
            topStart = 0.dp,
            topEnd = 0.dp
        ),
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background) // Use the primary color from the theme,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(MaterialTheme.colorScheme.inversePrimary),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Left area: back button
            Row(modifier = Modifier.weight(1f), verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = { goTo(Screen.Back) }) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                }
            }

            // Title centered
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1f)
            )

            // Right side: search & home
            Row(
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Search Button
                Button(
                    onClick = { goTo(Screen.Search) },
                    contentPadding = PaddingValues(horizontal = 0.dp, vertical = 0.dp)
                ) {
                    Icon(imageVector = Icons.Default.Search, contentDescription = "")
                }

                Spacer(modifier = Modifier.width(20.dp))

                // Home Button
                Button(
                    onClick = { goTo(Screen.Main) },
                    contentPadding = PaddingValues(horizontal = 0.dp, vertical = 0.dp)
                ) {
                    Icon(imageVector = Icons.Default.Home, contentDescription = "")
                }
                Spacer(modifier = Modifier.width(30.dp))
            }
        }
    }
}