package de.zelkulon.timezelkulon.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import de.zelkulon.timezelkulon.model.InfoCard

@Database(entities = [InfoCard::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun infoCardDao(): InfoCardDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        // Migration von Version 1 zu Version 2
        private val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                // Füge die neue Spalte 'day' hinzu und setze einen Standardwert
                database.execSQL("ALTER TABLE info_cards ADD COLUMN day TEXT NOT NULL DEFAULT 'Monday'")
            }
        }

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "info_card_database"
                )
                    .addMigrations(MIGRATION_1_2) // Migration hinzufügen
                    //.fallbackToDestructiveMigration() // Optional: Zerstörende Migration während der Entwicklung
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
