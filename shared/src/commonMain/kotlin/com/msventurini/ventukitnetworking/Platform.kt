package com.msventurini.ventukitnetworking

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform