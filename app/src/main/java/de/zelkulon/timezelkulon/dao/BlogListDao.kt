package de.zelkulon.timezelkulon.dao
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import de.zelkulon.timezelkulon.model.BlogList
import kotlinx.coroutines.flow.Flow

@Dao
interface BlogListDao {
    @Query("SELECT * FROM blog_list")
    fun getAllBlogLists(): Flow<List<BlogList>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBlogLists(blogLists: List<BlogList>)
}
