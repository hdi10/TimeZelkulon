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
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.findViewTreeLifecycleOwner


class ThursdayActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainThursdayContent()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainThursdayContent() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Thursday", color = MaterialTheme.colorScheme.primary) },
                Modifier.background(Color.Red)
            )
        },
        content = { paddingValues ->
            ThursdayContent(Modifier.padding(paddingValues))
        }
    )
}



@Composable
fun ThursdayContent(modifier: Modifier = Modifier) {
    Column(modifier) {
        Text(text = "Hier Daten vom Donnerstag")
    }
}

@Preview
@Composable
fun ImageBitmapSnippets() {
    // [START android_compose_images_bitmap_load]
    Image(
        painter = painterResource(id = R.drawable.dog_51509),
        contentDescription = stringResource(id = R.string.dog_content_description)
    )
    // [END android_compose_images_bitmap_load]

    // [START android_compose_images_bitmap_simple]
    val imageBitmap = ImageBitmap.imageResource(R.drawable.dog_51509)
    // [END android_compose_images_bitmap_simple]
}



