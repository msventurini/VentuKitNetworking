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
         url: "https://github.com/msventurini/VentuKitNetworking/releases/download/0.0.6/VentuKitNetworking.xcframework.zip",
         checksum:"961e5f487bb022308d34895efc8ee2eb8adb8be1e1788650e2e1efc4cbe42825")
   ]
)
