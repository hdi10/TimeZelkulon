package de.zelkulon.timezelkulon.dao

import de.zelkulon.timezelkulon.api.BlogApiService
import de.zelkulon.timezelkulon.model.Blog
import kotlinx.coroutines.flow.Flow

class BlogRepository(
    private val blogDao: BlogDao,
    private val blogApiService: BlogApiService
) {



    // Holt Blogs aus der lokalen Datenbank
    fun getLocalBlogs(): Flow<List<Blog>> = blogDao.getAllBlogs()

    // Lädt Blogs von der API
    suspend fun fetchBlogsFromApi(): List<Blog> {
        return blogApiService.getBlogs()
    }

    // Synchronisiert API-Blogs mit der lokalen Datenbank
    suspend fun syncBlogs() {
        val apiBlogs = fetchBlogsFromApi()
        blogDao.insertBlogs(apiBlogs) // Speichert die API-Blogs in der lokalen Datenbank
    }

    suspend fun postBlog(blog: Blog) {
        val response = blogApiService.insertBlog(blog)
        blogDao.postBlog(response) // Optional: Lokale Speicherung
    }

}
