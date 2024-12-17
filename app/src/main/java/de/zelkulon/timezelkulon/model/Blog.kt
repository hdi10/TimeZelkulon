package de.zelkulon.timezelkulon.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "blog")
data class Blog(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val artist: String,
    val location: String,
    val timestamp: String     // kein Fehler--> TypeConverter DateConverter
)


