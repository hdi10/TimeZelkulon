package de.zelkulon.timezelkulon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import de.zelkulon.timezelkulon.dao.BlogViewModel
import de.zelkulon.timezelkulon.dao.BlogRepository
import de.zelkulon.timezelkulon.ui.model.BlogListScreen

class BlogActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialisiere die Datenbank und das Repository
        val database = AppDatabase.getDatabase(applicationContext)
        val repository = BlogRepository(database.blogDao())

        // Initialisiere das ViewModel
        val viewModel = BlogViewModel(repository)

        // Füge Testdaten in die Datenbank ein (nur einmal ausführen, nicht jedes Mal beim Start)
        viewModel.insertTestData()

        // Setze die Compose-Oberfläche
        setContent {
            BlogListScreen(viewModel = viewModel)
        }
    }
}
