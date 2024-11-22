package de.zelkulon.timezelkulon.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import de.zelkulon.timezelkulon.model.InfoCard

@Database(entities = [InfoCard::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun infoCardDao(): InfoCardDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "info_card_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
