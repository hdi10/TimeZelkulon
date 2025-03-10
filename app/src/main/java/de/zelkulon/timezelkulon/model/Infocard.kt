package de.zelkulon.timezelkulon.model

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "info_cards")
data class InfoCard(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val text: String,
    val prio: Int,
    val day: String
)