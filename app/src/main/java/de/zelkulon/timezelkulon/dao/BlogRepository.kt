package de.zelkulon.timezelkulon.dao

import de.zelkulon.timezelkulon.model.Blog
import kotlinx.coroutines.flow.Flow

class BlogRepository(private val blogDao: BlogDao) {
    // Lade alle Blogs aus der Datenbank
    fun getAllBlogs(): Flow<List<Blog>> = blogDao.getAllBlogs() // Direkt als Flow zurückgeben

    // Füge Blogs in die Datenbank ein
    suspend fun insertBlogs(blogs: List<Blog>) {
        blogDao.insertBlogs(blogs)
    }
}
