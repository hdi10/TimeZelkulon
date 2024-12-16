
package de.zelkulon.timezelkulon.dao


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import de.zelkulon.timezelkulon.model.Blog
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.Date

class BlogViewModel(private val repository: BlogRepository) : ViewModel() {
    private val _blogs = MutableStateFlow<List<Blog>>(emptyList())
    val blogs: StateFlow<List<Blog>> get() = _blogs

    init {
        loadBlogs()
    }

    // Lädt Blogs aus der Datenbank
    private fun loadBlogs() {
        viewModelScope.launch {
            repository.getAllBlogs().collect { blogList ->
                _blogs.value = blogList
            }
        }
    }

    // Füge Testdaten ein (nur für Entwicklungszwecke)
    fun insertTestData() {
        viewModelScope.launch {
            val blogs = listOf(
                Blog(1, "Exploring Java", "John Doe", "Berlin", Date()),
                Blog(2, "Spring Boot Essentials", "Jane Smith", "Munich", Date())
            )
            repository.insertBlogs(blogs)
        }
    }
}
