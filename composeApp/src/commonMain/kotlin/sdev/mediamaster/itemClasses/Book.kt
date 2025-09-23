package sdev.mediamaster.itemClasses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Book(
    @SerialName("title")
    override val title: String,
    @SerialName("description")
    override val description: String,
    override val imageUrl: String,
    val author: String
) : Item
