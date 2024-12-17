import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import de.zelkulon.timezelkulon.dao.BlogViewModel
import de.zelkulon.timezelkulon.model.Blog
import java.util.Date

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import de.zelkulon.timezelkulon.ui.components.BlogInputScreen

@Composable
fun BlogListScreen(viewModel: BlogViewModel) {
    val blogs by viewModel.blogs.collectAsState()
    var showInputScreen by remember { mutableStateOf(false) }

    if (showInputScreen) {
        // Eingabefenster anzeigen
        BlogInputScreen(onSubmit = { newBlog ->
            viewModel.postBlog(newBlog)
            showInputScreen = false // Schließe das Eingabefenster
        })
    } else {
        Column(modifier = Modifier.fillMaxSize()) {
            // Sync Button
            Button(onClick = { viewModel.syncBlogsFromApi() }) {
                Text("Sync Blogs")
            }

            // Post Button öffnet Eingabeformular
            Button(onClick = { showInputScreen = true }, modifier = Modifier.padding(8.dp)) {
                Text("Neuen Blog erstellen")
            }

            // Blog-Liste anzeigen
            LazyColumn {
                items(blogs) { blog ->
                    BlogItem(blog)
                }
            }
        }
    }
}


@Composable
fun BlogItem(blog: Blog) {
    Column(modifier = Modifier.padding(8.dp)) {
        Text("Title: ${blog.title}")
        Text("Artist: ${blog.artist}")
        Text("Location: ${blog.location}")
        Text("Timestamp: ${blog.timestamp}")
    }
}

