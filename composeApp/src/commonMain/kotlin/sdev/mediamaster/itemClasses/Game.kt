package sdev.mediamaster.itemClasses


class Game(
    name: String,
    description: String,
    releaseYear: Int,
    imageUrl: String,
    val platform: String,
    val genre: String? = null,
    val developer: String? = null,
) : Item(name, description, releaseYear, imageUrl)
