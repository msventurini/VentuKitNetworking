package ventukitnetworking

class AndroidPlatform: PlatformData {
    override val name: String =
        "Android ${android.os.Build.VERSION.SDK_INT}"
}

actual fun getPlatform(): PlatformData = AndroidPlatform()