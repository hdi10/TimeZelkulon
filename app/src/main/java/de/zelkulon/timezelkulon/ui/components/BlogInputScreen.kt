package de.zelkulon.timezelkulon.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import de.zelkulon.timezelkulon.model.Blog
import java.time.Instant
import java.time.format.DateTimeFormatter


@Composable
fun BlogInputScreen(onSubmit: (Blog) -> Unit) {
    var title by remember { mutableStateOf("") }
    var artist by remember { mutableStateOf("") }
    var location by remember { mutableStateOf("") }


    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {

        Text("Neuer Blogeintrag", style = MaterialTheme.typography.titleLarge)

        // Eingabefelder
        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Titel") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
        )

        OutlinedTextField(
            value = artist,
            onValueChange = { artist = it },
            label = { Text("Künstler") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
        )

        OutlinedTextField(
            value = location,
            onValueChange = { location = it },
            label = { Text("Ort") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
        )

        // Speichern Button
        Button(
            onClick = {
                // Aktuelles Datum im ISO 8601-Format
                val timestamp = DateTimeFormatter.ISO_INSTANT.format(Instant.now())

                val newBlog = Blog(
                    title = title,
                    artist = artist,
                    location = location,
                    timestamp = timestamp
                )
                onSubmit(newBlog) // Callback mit dem neuen Blog
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Blog speichern")
        }
    }
}
