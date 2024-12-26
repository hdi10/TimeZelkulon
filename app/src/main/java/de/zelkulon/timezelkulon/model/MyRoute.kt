package de.zelkulon.timezelkulon.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "myroutes")
data class MyRoute (@PrimaryKey(autoGenerate = true)val id:Long=0,
    val name: String,
    val dateTime:Long //Unix Timestamp
)