package de.zelkulon.timezelkulon.ui.components

import android.content.Intent
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
import de.zelkulon.timezelkulon.MondayActivity
import de.zelkulon.timezelkulon.R
import de.zelkulon.timezelkulon.SaturdayActivity
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun getNextSaturday(): LocalDate {
    val today = LocalDate.now()
    val daysUntilSaturday = DayOfWeek.SATURDAY.value - today.dayOfWeek.value
    return today.plusDays(if (daysUntilSaturday >= 0) daysUntilSaturday.toLong() else (daysUntilSaturday + 7).toLong())
}

@OptIn(ExperimentalComposeApi::class)
@Composable
fun SaturdayCard() {
    val nextSaturday = getNextSaturday()
    val dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
    val formattedDate = nextSaturday.format(dateFormatter)
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
        Row {
            Image(
                painter = painterResource(id = R.drawable.saturday),
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
                context.startActivity(Intent(context, SaturdayActivity::class.java))
            }
        }
    }


}