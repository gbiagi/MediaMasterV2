package sdev.mediamaster.itemClasses

class Movie(
    name: String,
    description: String,
    releaseYear: Int,
    imageUrl: String,
    val director: String
) : Item(name, description, releaseYear, imageUrl)
