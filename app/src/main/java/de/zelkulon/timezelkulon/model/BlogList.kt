package de.zelkulon.timezelkulon.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "blog_list")
data class BlogList(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val ownerId: String,
    val name: String,
    val isPrivate: Boolean
)
