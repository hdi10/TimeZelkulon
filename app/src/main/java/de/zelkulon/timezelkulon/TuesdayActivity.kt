package de.zelkulon.timezelkulon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.wear.compose.material.rememberSwipeableState
import de.zelkulon.timezelkulon.dao.AppDatabase
import de.zelkulon.timezelkulon.dao.InfoCardRepository
import de.zelkulon.timezelkulon.dao.InfoCardViewModel
import de.zelkulon.timezelkulon.model.InfoCard

class TuesdayActivity : ComponentActivity() {
    private lateinit var viewModel: InfoCardViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ViewModel initialisieren
        val dao = AppDatabase.getDatabase(this).infoCardDao()
        val repository = InfoCardRepository(dao)
        viewModel = InfoCardViewModel(repository)

        setContent {
            MainTuesdayContent(viewModel)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTuesdayContent(viewModel: InfoCardViewModel) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Tuesday", color = MaterialTheme.colorScheme.primary) },
                Modifier.background(Color.Red)
            )
        },
        content = { paddingValues ->
            TuesdayContent(viewModel, Modifier.padding(paddingValues))
        }
    )
}

@Composable
fun TuesdayContent(viewModel: InfoCardViewModel, modifier: Modifier = Modifier) {
    Column(modifier) {
        Text(text = "Hier sind die Daten vom Dienstag")

        // Einbinden der InfoCardScreen
        InfoCardScreen(viewModel)
    }
}

@Composable
fun InfoCardScreen(viewModel: InfoCardViewModel) {
    val infoCards by viewModel.infoCards.collectAsState()

    Column {
        // Eingabeformular
        var text by remember { mutableStateOf("") }
        var prio by remember { mutableStateOf("") }

        Row {
            TextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Text") },
                modifier = Modifier.weight(1f)
            )
            TextField(
                value = prio,
                onValueChange = { prio = it },
                label = { Text("Prio") },
                modifier = Modifier.weight(1f),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Button(onClick = {
                if (text.isNotEmpty() && prio.isNotEmpty()) {
                    viewModel.addInfoCard(text, prio.toInt())
                }
            }) {
                Text("Hinzufügen")
            }
        }

        // Anzeige der InfoCards
        LazyColumn {
            items(infoCards) { card ->
                Row(modifier = Modifier.padding(8.dp)) {
                    Text(
                        text = "${card.text} - Prio: ${card.prio}",
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.weight(1f)
                    )
                    Button(
                        onClick = { viewModel.deleteInfoCard(card) },
                        modifier = Modifier.padding(start = 8.dp)
                    ) {
                        Text("Löschen")
                    }
                }
            }
        }
    }
}
