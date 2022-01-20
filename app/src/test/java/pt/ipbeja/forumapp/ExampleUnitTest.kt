package pt.ipbeja.forumapp

import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.*
import io.ktor.client.features.get
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.utils.io.*
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import org.junit.Assert.assertEquals
import org.junit.Test
import pt.ipbeja.forumapp.remote.Api
import pt.ipbeja.forumapp.remote.Post

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    private val client = HttpClient(Android) {

        engine {
            connectTimeout = 10_000
        }

        install(JsonFeature) {
            serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                ignoreUnknownKeys = true
                isLenient = true
            })
        }
    }

    @Test
    fun addPostTest() = runBlocking {
        val post = Post("My post")
        Api.addPost(post)
    }

    @Test
    fun addLikeTest() = runBlocking {
        Api.addLike(5)
    }

    @Test
    fun getAllLaunches() = runBlocking {
        val flightNumber = 65
        val r = client.get<Launch>("https://api.spacexdata.com/v3/launches/$flightNumber")
        println(r)
    }


    @Serializable
    data class Launch(
        @SerialName("flight_number") val flightNumber: String,
        @SerialName("mission_name")val missionName: String,
        val rocket: Rocket
    )

    @Serializable
    data class Rocket(
        @SerialName("rocket_id") val rocketId: String,
        @SerialName("rocket_name") val rocketName: String
    )

}