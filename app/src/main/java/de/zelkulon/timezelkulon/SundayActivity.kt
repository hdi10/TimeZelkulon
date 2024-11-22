package de.zelkulon.timezelkulon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

class SundayActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainSundayContent()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainSundayContent() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Sunday", color = Color.Magenta) },
                Modifier.background(Color.Red)
            )
        },
        content = { paddingValues ->
            SundayContent(Modifier.padding(paddingValues))
        }
    )
}

@Composable
fun SundayContent(modifier: Modifier = Modifier) {
    Column(modifier) {
        Text(text = "Hier Daten vom Sonntag")
    }
}