package ventukitnetworking

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

class NetworkClient {

    val client = HttpClient()

    suspend fun greeting(): String {
        val response = client.get("https://www.gamerpower.com/api/giveaways")
//        client.close()
        return response.bodyAsText()
    }
}