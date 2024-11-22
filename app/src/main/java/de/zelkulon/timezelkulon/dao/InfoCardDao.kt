package de.zelkulon.timezelkulon.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import de.zelkulon.timezelkulon.model.InfoCard

@Dao
interface InfoCardDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(infoCard: InfoCard): Long

    @Query("SELECT * FROM info_cards ORDER BY prio ASC")
    suspend fun getAllCards(): List<InfoCard>

    @Delete
    suspend fun delete(infoCard: InfoCard) // Direktes Löschen eines Objekts

    @Query("DELETE FROM info_cards WHERE id = :id")
    suspend fun deleteById(id: Int) // Löschen anhand der ID
}
