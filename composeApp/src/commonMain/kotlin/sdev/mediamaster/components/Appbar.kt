import sdev.mediamaster.NavigationTarget
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
import androidx.compose.material3.Icon

@Composable
fun Appbar(title: String, goTo: (NavigationTarget) -> Unit) {
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
            // Left side space to center the title
            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center
            )
            // Second row to hold everything on the right side
            Row(
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Search Button
                Button(
                    onClick = { goTo(NavigationTarget.SEARCH) },
                    contentPadding = PaddingValues(horizontal = 0.dp, vertical = 0.dp)
                ) {
                    Icon(imageVector = Icons.Default.Search, contentDescription = "")
                }

                Spacer(modifier = Modifier.width(20.dp))

                // Home Button
                Button(
                    onClick = { goTo(NavigationTarget.MAIN) },
                    contentPadding = PaddingValues(horizontal = 0.dp, vertical = 0.dp)
                ) {
                    Icon(imageVector = Icons.Default.Home, contentDescription = "")
                }
                Spacer(modifier = Modifier.width(30.dp))
            }
        }
    }
}