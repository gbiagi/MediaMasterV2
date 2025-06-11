package sdev.mediamaster

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform