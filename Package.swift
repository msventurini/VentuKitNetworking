// swift-tools-version:5.3
import PackageDescription

let package = Package(
   name: "VentuKitNetworking",
   platforms: [
     .iOS(.v14),
   ],
   products: [
      .library(name: "VentuKitNetworking", targets: ["VentuKitNetworking"])
   ],
   targets: [
      .binaryTarget(
         name: "Shared",
         url: "https://github.com/msventurini/VentuKitNetworking/releases/download/0.0.5/VentuKitNetworking.xcframework.zip",
         checksum:"3e6ab47e267206aae89dbdbad9a664c26177a4e7979ce5127766e03e9ef5fe8a")
   ]
)
