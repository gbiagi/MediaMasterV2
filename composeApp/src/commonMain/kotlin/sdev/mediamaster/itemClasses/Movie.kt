package sdev.mediamaster.itemClasses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Movie(
    @SerialName("original_title")
    override val title: String,
    @SerialName("overview")
    val description: String,
    @SerialName("backdrop_path")
    override var imageUrl: String,
    @SerialName("runtime")
    val runtime: Int,
    @SerialName("release_date")
    val releaseYear: String
) : Item
