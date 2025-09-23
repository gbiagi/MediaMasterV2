package sdev.mediamaster.network

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.HttpHeaders
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import sdev.mediamaster.itemClasses.Item
import sdev.mediamaster.itemClasses.Movie

// tmbd img url https://image.tmdb.org/t/p/w500 + poster_path
// open library img https://covers.openlibrary.org/b/id/{}.jpg add cover id

object ApiClient {
    val client = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                isLenient = true
            })
        }
        // Extra config (timeouts, logging, etc.)
    }

    suspend fun getMovie(id: String): Movie {
        val response = client.get("http://localhost:3000/mmserver/movie/$id")
        // Puedes imprimir el JSON crudo para debug
        println(response.body<String>())

        val movie = response.body<Movie>()

        println(movie)
        // Deserializa directamente a Movie
        return movie;
    }

}