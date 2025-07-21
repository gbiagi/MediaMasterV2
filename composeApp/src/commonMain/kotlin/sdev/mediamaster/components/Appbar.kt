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
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center
            )
            Button(onClick = { goTo(NavigationTarget.MAIN) }) {
                Text("Main")
            }
            // Add padding to the right
            Spacer(modifier = Modifier.width(20.dp))
        }
    }
}