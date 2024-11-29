import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import com.composables.icons.lucide.ArrowBigLeft
import com.composables.icons.lucide.Lucide

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAppBar(
    title: String,
    showNavigationIcon: Boolean = false,
    onNavigationClick: () -> Unit = {}
) {
    TopAppBar(
        title = {
            Text(text = title)
        },
        navigationIcon = if (showNavigationIcon) {
            {
                IconButton(onClick = onNavigationClick) {
                    Icon(
                        imageVector = Lucide.ArrowBigLeft,
                        contentDescription = "Back"
                    )
                }
            }
        } else {
            {} // Use an empty composable
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = androidx.compose.material3.MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = androidx.compose.material3.MaterialTheme.colorScheme.primary,
        )
    )
}
