package de.zelkulon.timezelkulon.ui.components

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ExperimentalComposeApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.zelkulon.timezelkulon.MondayActivity
import de.zelkulon.timezelkulon.R
import de.zelkulon.timezelkulon.TuesdayActivity
import de.zelkulon.timezelkulon.ui.theme.TimeZelkulonTheme
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun getNextTuesday(): LocalDate {
    val today = LocalDate.now()
    val daysUntilTuesday = DayOfWeek.TUESDAY.value - today.dayOfWeek.value
    return today.plusDays(if (daysUntilTuesday >= 0) daysUntilTuesday.toLong() else (daysUntilTuesday + 7).toLong())
}

@OptIn(ExperimentalComposeApi::class)
@Composable
fun TuesdayCard() {
    val nextTuesday = getNextTuesday()
    val dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
    val formattedDate = nextTuesday.format(dateFormatter)
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
            .padding(horizontal = 0.73.dp) // Optionaler horizontaler Padding
            .height(64.dp) // Feste Höhe der Karte
    ) {
        Row/*(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        )*/ {
            Image(
                painter = painterResource(id = R.drawable.tuesday),
                contentDescription = "Card of Day",
                modifier = Modifier
                    .size(50.dp)
                    .padding()
            )
            Text(
                text = formattedDate,
                fontSize = 30.sp,
                modifier = Modifier.padding(16.dp),
                textAlign = TextAlign.Center
            )
            AddButton() {
                context.startActivity(Intent(context, TuesdayActivity::class.java))
            }
        }
    }


}
/*{
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Nächster Dienstag",
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = formattedDate,
            style = MaterialTheme.typography.bodyMedium
        )
    }*/


@Preview(showBackground = true)
@Composable
fun TuesdayCardPreview() {
    TimeZelkulonTheme {
        Box(modifier = Modifier.padding(all = 10.dp)) {
            TuesdayCard()
        }
    }
}