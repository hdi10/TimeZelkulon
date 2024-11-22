package de.zelkulon.timezelkulon.ui.components

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ExperimentalComposeApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import de.zelkulon.timezelkulon.ui.theme.TimeZelkulonTheme

@OptIn(ExperimentalComposeApi::class)
@Composable
fun AddButton(onClick: () -> Unit) {
    FilledTonalButton(onClick = { onClick() }) {
        Text("Füge Notiz zu dem Tag hinzu")
    }
}



@Preview(showBackground = true)
@Composable
fun AddButtonPrevie(){
    TimeZelkulonTheme {
        val context = LocalContext.current
        fun toast(){
            Toast.makeText(context,"Hoooraaay",Toast.LENGTH_SHORT).show()
        }

        Box(modifier = Modifier.padding(all = 5.dp)) {
            AddButton (){
                toast()
            }
        }
    }
}