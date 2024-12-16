package de.zelkulon.timezelkulon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import de.zelkulon.timezelkulon.dao.BlogViewModel
import de.zelkulon.timezelkulon.dao.BlogRepository
import de.zelkulon.timezelkulon.instances.RetrofitInstance
import de.zelkulon.timezelkulon.ui.model.BlogListScreen


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
