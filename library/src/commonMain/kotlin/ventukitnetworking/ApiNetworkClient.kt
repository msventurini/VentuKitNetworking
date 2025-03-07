package ventukitnetworking

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ApiNetworkClient: NetworkClient {

    val client = HttpClient()

    override suspend fun greeting(): String {

//        val response = client.get("https://www.gamerpower.com/api/giveaways")
//        client.close()
//        return response.bodyAsText()

        return "MAH OE"
    }

    var giveaways: List<GameData> = emptyList()


    init {
        giveaways = currentGiveawaysMockedData()
    }

    override fun listEmitter(): Flow<GameData> = flow {
        giveaways.forEach { game ->
            emit(value = game)
        }
    }
}