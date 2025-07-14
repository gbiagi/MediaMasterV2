package sdev.mediamaster.itemClasses

class Book(
    name: String,
    description: String,
    releaseYear: Int,
    imageUrl: String,
    val author: String
) : Item(name, description, releaseYear, imageUrl)
