package de.zelkulon.timezelkulon.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import de.zelkulon.timezelkulon.model.Blog
import kotlinx.coroutines.flow.Flow

@Dao
interface BlogDao {
    @Query("SELECT * FROM blog")
    fun getAllBlogs(): Flow<List<Blog>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBlogs(blogs: List<Blog>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
        suspend fun postBlog(blog: Blog)
}