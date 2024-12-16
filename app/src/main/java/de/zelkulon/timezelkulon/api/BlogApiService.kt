package de.zelkulon.timezelkulon.api

import de.zelkulon.timezelkulon.model.Blog
import retrofit2.http.GET

interface BlogApiService {
    @GET("/blogs")
    suspend fun getBlogs(): List<Blog>
}