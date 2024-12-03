package de.zelkulon.timezelkulon


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
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

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import de.zelkulon.timezelkulon.dao.AppDatabase
import de.zelkulon.timezelkulon.dao.DayInfoCardViewModel
import de.zelkulon.timezelkulon.dao.InfoCardRepository

class MondayActivity : ComponentActivity() {
    private lateinit var viewModel: DayInfoCardViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dao = AppDatabase.getDatabase(this).infoCardDao()
        val repository = InfoCardRepository(dao)
        viewModel = DayInfoCardViewModel(repository,"Monday")
        setContent {
            MainMondayContent(viewModel)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainMondayContent(viewModel: DayInfoCardViewModel) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Monday", color = MaterialTheme.colorScheme.primary) },
                Modifier.background(Color.Red)
            )
        },
        content = { paddingValues ->
            MondayContent(viewModel,Modifier.padding(paddingValues))
        }
    )
}

@Composable
fun MondayContent(viewModel: DayInfoCardViewModel,modifier: Modifier = Modifier) {
    Column(modifier) {
        Text(text = "Hier Montagsdaten")

//        Image(
//            painter = painterResource(id = ),
//            contentDescription = stringResource(id = R.string.dog_content_description)
//        )
//
//        InfoCardScreen(viewModel = viewModel)
    }
}