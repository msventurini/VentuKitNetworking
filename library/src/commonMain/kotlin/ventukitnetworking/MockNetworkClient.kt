package ventukitnetworking

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GamerPowerMockData: NetworkClient {

    var giveaways: List<GameData> = emptyList()


    init {
        giveaways = currentGiveawaysMockedData()
    }



//    fun oneToTenFlow(): Flow<String> = flow {
//        (1..10).forEach {
//            emit("Number = $it")
//            delay(1000)
//        }
//    }

    override suspend fun greeting(): String {
        return "wa"
    }

    override fun listEmitter(): Flow<GameData> = flow {
        giveaways.forEach { game ->
            emit(value = game)
        }
    }

}

//class MockNetworkClient: NetworkClient {
//
////    val jsonMockedResponse: JsonO
//
//    override suspend fun greeting(): String {
//        val client = HttpClient()
//        val response = client.get("https://www.gamerpower.com/api/giveaways")
//        client.close()
//        return response.bodyAsText()
//    }
//}