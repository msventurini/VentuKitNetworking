package com.msventurini.ventukitnetworking

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

class NetworkWorker {

    private val client = HttpClient()

    suspend fun basicRequest(): String {
        val response = client.get("https://www.gamerpower.com/api/giveaways")
        return response.bodyAsText()

//        val response = client.get {
//            url {
//                protocol = URLProtocol.HTTPS
//                host = "ktor.io"
//                path("docs/welcome.html")
//            }
//        }

    }

}