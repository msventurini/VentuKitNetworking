package ventukitnetworking

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface NetworkClient {

    suspend fun greeting(): String

    fun listEmitter(): Flow<GameData>


}