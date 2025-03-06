package ventukitnetworking

interface PlatformData {
    val name: String
}

expect fun getPlatform(): PlatformData