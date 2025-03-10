package de.zelkulon.timezelkulon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import de.zelkulon.timezelkulon.ui.components.FridayCard
import de.zelkulon.timezelkulon.ui.components.MyCard
import de.zelkulon.timezelkulon.ui.components.SaturdayCard
import de.zelkulon.timezelkulon.ui.components.SundayCard
import de.zelkulon.timezelkulon.ui.components.ThursdayCard
import de.zelkulon.timezelkulon.ui.components.TuesdayCard
import de.zelkulon.timezelkulon.ui.components.WednesdayCard
import de.zelkulon.timezelkulon.ui.theme.TimeZelkulonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TimeZelkulonTheme {
                ScrollBoxesSmooth()
            }
        }
    }
}

@Composable
private fun ScrollBoxesSmooth() {
    // Smoothly scroll 100px on first composition
    val state = rememberScrollState()
    LaunchedEffect(Unit) { state.animateScrollTo(100) }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.LightGray)
            .verticalScroll(state)
    ) {
        Spacer(modifier = Modifier.padding(15.dp))
        MyCard()
        Spacer(modifier = Modifier.padding(15.dp))
        TuesdayCard()
        Spacer(modifier = Modifier.padding(15.dp))
        WednesdayCard()
        Spacer(modifier = Modifier.padding(15.dp))
        ThursdayCard()
        Spacer(modifier = Modifier.padding(15.dp))
        FridayCard()
        Spacer(modifier = Modifier.padding(15.dp))
        SaturdayCard()
        Spacer(modifier = Modifier.padding(15.dp))
        SundayCard()
//        AddButton {
//            Toast.makeText(context,"Hooray",Toast.LENGTH_SHORT).show()
//        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}



