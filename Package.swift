// swift-tools-version:5.3
import PackageDescription

let package = Package(
   name: "Shared",
   platforms: [
     .iOS(.v14),
   ],
   products: [
      .library(name: "Shared", targets: ["Shared"])
   ],
   targets: [
      .binaryTarget(
         name: "Shared",
         url: "https://github.com/msventurini/VentuKitNetworking/releases/download/v0.0.1-alpha/shared.xcframework.zip",
         checksum:"4a5aca3f688dcaf20fb3ac6b3bf93f5d6a07d35f98021279528bc790e3ba2173")
   ]
)
