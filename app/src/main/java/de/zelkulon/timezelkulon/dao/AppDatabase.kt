package de.zelkulon.timezelkulon

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import de.zelkulon.timezelkulon.dao.BlogDao
import de.zelkulon.timezelkulon.dao.BlogListDao
import de.zelkulon.timezelkulon.dao.ContainsBlogDao
import de.zelkulon.timezelkulon.dao.DateConverter
import de.zelkulon.timezelkulon.dao.InfoCardDao
import de.zelkulon.timezelkulon.model.Blog
import de.zelkulon.timezelkulon.model.BlogList
import de.zelkulon.timezelkulon.model.ContainsBlog
import de.zelkulon.timezelkulon.model.InfoCard

@Database(
    entities = [InfoCard::class, Blog::class, BlogList::class, ContainsBlog::class],
    version = 5, // Version auf 5 erhöhen
    exportSchema = false
)
@TypeConverters(DateConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun infoCardDao(): InfoCardDao
    abstract fun blogDao(): BlogDao
    abstract fun blogListDao(): BlogListDao
    abstract fun containsBlogDao(): ContainsBlogDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "info_card_database"
                )
                    .addMigrations(MIGRATION_4_5) // Die neue Migration hinzufügen
                    .fallbackToDestructiveMigration() // Fallback für fehlende Migrationen
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}

// Migration von Version 1 auf Version 2
val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL(
            "CREATE TABLE IF NOT EXISTS info_card (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, title TEXT NOT NULL)"
        )
    }
}

// Migration von Version 2 auf Version 3
val MIGRATION_2_3 = object : Migration(2, 3) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE info_card ADD COLUMN description TEXT")
    }
}

// Migration von Version 3 auf Version 4
val MIGRATION_3_4 = object : Migration(3, 4) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL(
            """
            CREATE TABLE IF NOT EXISTS blog (
                id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
                title TEXT NOT NULL,
                artist TEXT NOT NULL,
                location TEXT NOT NULL,
                timestamp INTEGER NOT NULL
            )
            """
        )
        database.execSQL(
            """
            CREATE TABLE IF NOT EXISTS blog_list (
                id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
                ownerId TEXT NOT NULL,
                name TEXT NOT NULL,
                isPrivate INTEGER NOT NULL
            )
            """
        )
        database.execSQL(
            """
            CREATE TABLE IF NOT EXISTS contains_blog (
                blogListId INTEGER NOT NULL,
                blogId INTEGER NOT NULL,
                PRIMARY KEY (blogListId, blogId),
                FOREIGN KEY (blogListId) REFERENCES blog_list(id) ON DELETE CASCADE,
                FOREIGN KEY (blogId) REFERENCES blog(id) ON DELETE CASCADE
            )
            """
        )
    }
}

// Migration von Version 4 auf 5: Spalte 'day' hinzufügen
val MIGRATION_4_5 = object : Migration(4, 5) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE info_cards ADD COLUMN day TEXT NOT NULL DEFAULT ''")
    }
}
