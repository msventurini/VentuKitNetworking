package ventukitnetworking

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FlowValuesEmitter {
    fun oneToTenFlow(): Flow<String> = flow {
        (1..10).forEach {
            emit("Number = $it")
            delay(1000)
        }
    }
}