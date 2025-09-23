package sdev.mediamaster.itemClasses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Game(
    @SerialName("name")
    override val title: String,
    @SerialName("description_raw")
    override val description: String,
    @SerialName("background_image")
    override val imageUrl: String,
    @SerialName("released")
    val releaseYear: String,
//    val platform: String,
//    val genre: String,
    val developer: String,
) : Item
