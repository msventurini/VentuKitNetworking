package ventukitnetworking

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText

class MockNetworkClient: NetworkClient {

//    val jsonMockedResponse: JsonO

    override suspend fun greeting(): String {
        val client = HttpClient()
        val response = client.get("https://www.gamerpower.com/api/giveaways")
        client.close()
        return response.bodyAsText()
    }
}