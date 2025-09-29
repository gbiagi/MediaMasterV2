package sdev.mediamaster.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import sdev.mediamaster.itemClasses.ItemSearch

@Serializable
data class SearchResponse(
    @SerialName("results")
    val results: List<ItemSearch>
)
