package de.zelkulon.timezelkulon.ui.components

import android.widget.Toast
import androidx.compose.foundation.Image
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.zelkulon.timezelkulon.R
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun getNextSunday(): LocalDate {
    val today = LocalDate.now()
    val daysUntilSunday = DayOfWeek.SUNDAY.value - today.dayOfWeek.value
    return today.plusDays(if (daysUntilSunday >= 0) daysUntilSunday.toLong() else (daysUntilSunday + 7).toLong())
}

@OptIn(ExperimentalComposeApi::class)
@Composable
fun SundayCard (){
    val nextSunday = getNextSunday()
    val dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
    val formattedDate = nextSunday.format(dateFormatter)
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
                    painter = painterResource(id = R.drawable.sunday),
                    contentDescription = "Card of Day",
                    modifier = Modifier
                        .size(75.dp)
                        .padding()
                )
                Text(
                    text = formattedDate,
                    modifier = Modifier.padding(16.dp),
                    textAlign = TextAlign.Center
                )
            }
        }
        Spacer(modifier = Modifier.padding(3.dp))
        Row {

            AddButton() {
                Toast.makeText(context, "It's Sunday Chill!!", Toast.LENGTH_SHORT).show()
            }
        }

    }
}