package sdev.mediamaster.network

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import io.ktor.client.call.body
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.request.get
import io.ktor.http.path
import io.ktor.http.takeFrom
import sdev.mediamaster.itemClasses.Book
import sdev.mediamaster.itemClasses.Game
import sdev.mediamaster.itemClasses.ItemSearch
import sdev.mediamaster.itemClasses.Movie
import sdev.mediamaster.itemClasses.TV
import kotlin.text.append

object ApiClient {

    val client = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                isLenient = true
            })
        }
        //Config timeout
        install(HttpTimeout) {
            requestTimeoutMillis = 30 * 1000L
            connectTimeoutMillis = 10 * 1000L
        }
    }


    suspend fun search(category: String, query: String): List<ItemSearch> {
        return client.get {
            url {
                takeFrom("http://localhost:3000/")
                path("mmserver", "search${category.lowercase()}", query)
            }
        }
            .body<SearchResponse>()
            .results
            .take(5)
    }

    suspend fun getMovie(id: String): Movie {
        val response = client.get {
            url {
                takeFrom("http://localhost:3000")
                path("mmserver", "movie", id)
            }
        }
        return response.body<Movie>();
    }

    suspend fun getTV(id: String): TV {
        val response = client.get {
            url {
                takeFrom("http://localhost:3000")
                path("mmserver", "tv", id)
            }
        }
        return response.body<TV>();
    }

    suspend fun getBook(id: String): Book {
        val response = client.get {
            url {
                takeFrom("http://localhost:3000")
                path("mmserver", "book", id)
            }
        }
        return response.body<Book>();
    }

    suspend fun getGame(id: String): Game {
        val response = client.get {
            url {
                takeFrom("http://localhost:3000")
                path("mmserver", "game", id)
            }
        }
        return response.body<Game>();
    }

}