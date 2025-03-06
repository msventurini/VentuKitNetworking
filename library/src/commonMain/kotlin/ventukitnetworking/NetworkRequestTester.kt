package ventukitnetworking

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

class NetworkRequestTester {

    private val client = HttpClient()

    suspend fun text(): String {
        val response = client.get("https://ktor.io/docs/")
        return response.bodyAsText()
    }

}
