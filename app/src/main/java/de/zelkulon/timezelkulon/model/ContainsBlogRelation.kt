package de.zelkulon.timezelkulon.model
import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    tableName = "contains_blog",
    primaryKeys = ["blogListId", "blogId"],
    foreignKeys = [
        ForeignKey(
            entity = BlogList::class,
            parentColumns = ["id"],
            childColumns = ["blogListId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Blog::class,
            parentColumns = ["id"],
            childColumns = ["blogId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class ContainsBlog(
    val blogListId: Int,
    val blogId: Int
)
