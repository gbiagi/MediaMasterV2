package sdev.mediamaster.itemClasses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TV(
    @SerialName("original_title")
    override val title: String,
    @SerialName("overview")
    val description: String,
    @SerialName("backdrop_path")
    override var imageUrl: String,
    @SerialName("first_air_date")
    val firstAirDate: String,
    @SerialName("status")
    val status: String,
    val seasons: Int,
) : Item