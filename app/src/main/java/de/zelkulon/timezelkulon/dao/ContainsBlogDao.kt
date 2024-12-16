package de.zelkulon.timezelkulon.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import de.zelkulon.timezelkulon.model.ContainsBlog

@Dao
interface ContainsBlogDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertContainsBlogs(relations: List<ContainsBlog>)

    @Query("SELECT * FROM contains_blog")
    suspend fun getAllRelations(): List<ContainsBlog>
}


