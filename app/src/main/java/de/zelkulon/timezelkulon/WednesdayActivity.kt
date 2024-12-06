package de.zelkulon.timezelkulon

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
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
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import de.zelkulon.timezelkulon.dao.AppDatabase
import de.zelkulon.timezelkulon.dao.DayInfoCardViewModel
import de.zelkulon.timezelkulon.dao.InfoCardRepository
import de.zelkulon.timezelkulon.ui.components.HomeButton

class WednesdayActivity : ComponentActivity() {
    private lateinit var viewModel: DayInfoCardViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //init database
        val dao = AppDatabase.getDatabase(this).infoCardDao()
        val repository = InfoCardRepository(dao)

        viewModel = DayInfoCardViewModel(repository,"Wednesday")


        setContent {
            MainWednesdayContent(viewModel)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainWednesdayContent(viewModel: DayInfoCardViewModel) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Wednesday", color = MaterialTheme.colorScheme.primary) },
                Modifier.background(Color.Red)
            )
        },
        content = { paddingValues ->
            WednesdayContent(viewModel, Modifier.padding(paddingValues))
        }
    )
}

@Composable
fun WednesdayContent(viewModel: DayInfoCardViewModel, modifier: Modifier = Modifier) {
    Column(modifier) {
        val context = LocalContext.current // Für den HomeButton

        HomeButton {
            context.startActivity(Intent(context, MainActivity::class.java))
        }


        Image(
            painter = painterResource(id = R.drawable.imagewednesday),
            contentDescription = stringResource(id = R.string.dog_content_description)
        )

        InfoCardScreenWednesday(viewModel)
    }
}

// Eingabe - Formular
@Composable
fun InfoCardScreenWednesday(viewModel: DayInfoCardViewModel) {
    val infoCards by viewModel.infoCards.collectAsState()
    val context = LocalContext.current // Für den Toast

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
                    text = "" // Felder zurücksetzen
                    prio = ""
                } else {
                    // Zeige einen Toast, wenn ein Feld fehlt
                    Toast.makeText(
                        context,
                        "Bitte beide Felder ausfüllen!",
                        Toast.LENGTH_SHORT
                    ).show()
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