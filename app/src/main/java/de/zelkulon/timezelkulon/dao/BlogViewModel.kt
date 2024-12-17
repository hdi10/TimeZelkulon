package de.zelkulon.timezelkulon.dao

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import de.zelkulon.timezelkulon.model.Blog
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BlogViewModel(private val repository: BlogRepository) : ViewModel() {

    // StateFlow für die Blogs
    private val _blogs = MutableStateFlow<List<Blog>>(emptyList())
    val blogs: StateFlow<List<Blog>> get() = _blogs

    init {
        loadLocalBlogs()
    }

    // Holt Blogs aus der lokalen Datenbank
    private fun loadLocalBlogs() {
        viewModelScope.launch {
            repository.getLocalBlogs().collect { localBlogs ->
                _blogs.value = localBlogs
            }
        }
    }

    // Synchronisiert Blogs aus der API und lädt sie in die lokale Datenbank
    fun syncBlogsFromApi() {
        viewModelScope.launch {
            try {
                repository.syncBlogs()
                loadLocalBlogs() // Nach Synchronisierung lokale Blogs laden
            } catch (e: Exception) {
                // Fehlerbehandlung (z. B. API nicht erreichbar)
                e.printStackTrace()
            }
        }
    }

    fun postBlog(blog: Blog) {
        viewModelScope.launch {
            try {
                repository.postBlog(blog) // Blog an die API senden und optional lokal speichern
                syncBlogsFromApi()        // Lade die aktualisierten Blogs nach dem Posten
            } catch (e: Exception) {
                e.printStackTrace() // Fehlerbehandlung
            }
        }
    }

}
