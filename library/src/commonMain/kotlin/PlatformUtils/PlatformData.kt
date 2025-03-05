package PlatformUtils

interface PlatformData {
    val name: String
}

expect fun getPlatform(): PlatformData