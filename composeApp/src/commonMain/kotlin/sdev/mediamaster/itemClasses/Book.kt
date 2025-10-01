package sdev.mediamaster.itemClasses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Book(
    @SerialName("title")
    override val title: String,
    @SerialName("description")
    val description: String,
    override var imageUrl: String,
    val author: String
) : Item {
    val imgFullUrl: String
        get() = "https://covers.openlibrary.org/b/id/${imageUrl}.jpg"
}
