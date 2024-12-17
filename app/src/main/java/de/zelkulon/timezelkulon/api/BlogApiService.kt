package de.zelkulon.timezelkulon.api

import de.zelkulon.timezelkulon.model.Blog
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST

interface BlogApiService {
    @GET("/blogs")
    suspend fun getBlogs(): List<Blog>

    @POST("/blogs")
    suspend fun insertBlog(@Body blog: Blog): Blog

    @DELETE("/blogs/{id}")
    suspend fun deleteBlog(): String

}