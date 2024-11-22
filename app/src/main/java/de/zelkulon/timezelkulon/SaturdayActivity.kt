package de.zelkulon.timezelkulon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SaturdayActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainSaturdayContent()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainSaturdayContent() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Saturday", color = MaterialTheme.colorScheme.primary) },
                Modifier.background(Color.Red)
            )
        },
        content = { paddingValues ->
            SaturdayContent(Modifier.padding(paddingValues))
        }
    )
}

@Composable
fun SaturdayContent(modifier: Modifier = Modifier) {
    Column(modifier) {
        Text(text = "Hier Daten vom Samstag")
    }
}