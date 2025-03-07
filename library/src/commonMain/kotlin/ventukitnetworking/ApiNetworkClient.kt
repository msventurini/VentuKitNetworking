package ventukitnetworking

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

class ApiNetworkClient: NetworkClient {

    val client = HttpClient()

    override suspend fun greeting(): String {

        val response = client.get("https://www.gamerpower.com/api/giveaways")
//        client.close()
        return response.bodyAsText()
    }
}