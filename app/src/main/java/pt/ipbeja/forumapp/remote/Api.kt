package pt.ipbeja.forumapp.remote

import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.auth.*
import io.ktor.client.features.auth.providers.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.http.*
import java.lang.Exception

object Api {

    private const val BASE_URL = "https://pdm-21-forum.duckdns.org/forum"
    //private const val BASE_URL = "https://3.67.6.146/forum"

    private const val TIME_OUT = 5_000

    private val client = HttpClient(Android) {

        engine {
            connectTimeout = TIME_OUT
            socketTimeout = TIME_OUT
        }

        install(JsonFeature) {
            serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }

        install(Auth) {

            basic {
                credentials { BasicAuthCredentials("", "") } // ask teacher for creds
            }
        }

        // --- Optional ---

        /*install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
                    Log.v("Logger Ktor =>", message)
                }
            }
            level = LogLevel.ALL
        }

        install(ResponseObserver) {
            onResponse { response ->
                Log.d("HTTP status:", "${response.status.value}")
            }
        }*/


    }

    suspend fun getAllPosts() : List<Post> {
        // https://pdm-21-forum.duckdns.org/forum/posts/

       val urlString = "$BASE_URL/posts"
       return client.get<List<Post>>(urlString)

    }


    suspend fun addPost(post: Post) {
        val urlString = "$BASE_URL/posts"
        client.post<Boolean>(urlString) {
            contentType(ContentType.Application.Json)
            body = post
        }
    }

    suspend fun addComment(comment: Comment) {
        val urlString = "$BASE_URL/comments"
        client.post<Boolean>(urlString) {
            contentType(ContentType.Application.Json)
            body = comment
        }
    }

    suspend fun addLike(postId: Int) {
        val urlString = "$BASE_URL/likes"
        client.post<Boolean>(urlString) {
            contentType(ContentType.Application.Json)
            body = postId
        }
    }

    // TODO check ExampleUnitTest class for other examples using a different API
    
    // TODO Add the other requests:
    //  POST - addPost
    //  GET - getPost (get a single post by id) -> https://pdm-21-forum.duckdns.org/forum/posts/{postId}
    //  POST - addComment (add a comment to a Post) -> https://pdm-21-forum.duckdns.org/forum/comments -> Use the Comment model as the body (requires postId and text attributes)


    // Unsure
    //  POST - addLike (add a like to a Post) -> https://pdm-21-forum.duckdns.org/forum/likes -> Body is the postId

}















































