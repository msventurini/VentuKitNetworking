package PlatformUtils

import platform.UIKit.UIDevice

class IOSPlatform: PlatformData {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

actual fun getPlatform(): PlatformData = IOSPlatform()