package sdev.mediamaster.itemClasses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ItemSearch(
    @SerialName("id")
    val id: Int? = null,

    // BOOKS&MOVIES
    @SerialName("title")
    val title: String? = null,

    // TV&GAMES
    @SerialName("name")
    val name: String? = null,

    // MOVIE&TV
    @SerialName("poster_path")
    val poster_path: String? = null,

    // BOOKS
    @SerialName("cover_i")
    val coverId: String? = null,

    // GAMES
    @SerialName("background_image")
    val backgroundImage: String? = null

) {
    val displayTitle: String
        get() = title ?: name ?: ""

    val imageUrl: String
        get() = when {
            poster_path != null -> "https://image.tmdb.org/t/p/w500$poster_path"
            backgroundImage != null -> backgroundImage
            coverId != null -> "https://covers.openlibrary.org/b/id/$coverId.jpg"
            else -> ""
        }
}

// tmbd img url https://image.tmdb.org/t/p/w500 + poster_path
// open library img https://covers.openlibrary.org/b/id/{}.jpg add cover id


/*
* MOVIE
* title
* backdrop_path
*
* TV
* name
* backdrop_path
*
* BOOK
* title
* cover_i
*
* GAME
* name
* background_image
* */