package de.zelkulon.timezelkulon

import BlogListScreen
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

import de.zelkulon.timezelkulon.dao.BlogViewModel
import de.zelkulon.timezelkulon.dao.BlogRepository
import de.zelkulon.timezelkulon.instances.RetrofitInstance

class BlogActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialisiere die Datenbank und das Repository
        val database = AppDatabase.getDatabase(applicationContext)
        val repository = BlogRepository(
            blogDao = database.blogDao(),
            blogApiService = RetrofitInstance.api
        )

        // Initialisiere das ViewModel
        val viewModel = BlogViewModel(repository)

        // Setze die Compose-Oberfläche
        setContent {
            BlogListScreen(viewModel = viewModel)
        }
    }
}

@Composable
fun ButtonDefaults(){
Button(onClick = {




}) {

}
}

@Composable
@Preview
fun  onPreviewBlogAvtivity(){
Surface {
    de.zelkulon.timezelkulon.ButtonDefaults()
}
}