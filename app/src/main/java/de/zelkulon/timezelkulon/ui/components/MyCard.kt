package de.zelkulon.timezelkulon.ui.components

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ExperimentalComposeApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.zelkulon.timezelkulon.R
import de.zelkulon.timezelkulon.ui.theme.TimeZelkulonTheme
import java.time.LocalDate


@OptIn(ExperimentalComposeApi::class)
@Composable
fun MyCard() {
    val context = LocalContext.current
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 9.dp
        ),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.elevatedCardColors(
            containerColor = Color.LightGray,
            contentColor = Color.Black
        ),
        modifier = Modifier
            .fillMaxWidth() // Die Karte nimmt die gesamte verfügbare Breite ein
            .padding(horizontal = 8.dp) // Optionaler horizontaler Padding
            .height(200.dp) // Feste Höhe der Karte
    ) {
        Column {
            Row {
                Image(
                    painter = painterResource(id = R.drawable.monday),
                    contentDescription = "Card of Day",
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                )
                Text(
                    text = "Elevated",
                    modifier = Modifier.padding(16.dp),
                    textAlign = TextAlign.Center
                )
            }
        }
        Spacer(modifier = Modifier.padding(3.dp))
        Row {
            Text(
                text = LocalDate.now().dayOfMonth.toString() + "." + LocalDate.now().monthValue + "." + LocalDate.now().year,
                modifier = Modifier.padding(horizontal = 16.dp),
                style = TextStyle(fontSize = 12.sp),
            )
            AddButton() {
                Toast.makeText(context, "Hooray", Toast.LENGTH_SHORT).show()
            }
        }

    }
}


@Preview(showBackground = true)
@Composable
fun CardPreview() {
    TimeZelkulonTheme {
        Box(modifier = Modifier.padding(all = 10.dp)) {
            MyCard()
        }
    }
}