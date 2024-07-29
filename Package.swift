// swift-tools-version: 5.9
import PackageDescription

let package = Package(
    name: "SkirankCopyAndroid",
    platforms: [.iOS(.v13)],
    products: [
        .library(
            name: "SkirankCopyAndroid",
            targets: ["CopyAndroidPlugin"])
    ],
    dependencies: [
        .package(url: "https://github.com/ionic-team/capacitor-swift-pm.git", branch: "main")
    ],
    targets: [
        .target(
            name: "CopyAndroidPlugin",
            dependencies: [
                .product(name: "Capacitor", package: "capacitor-swift-pm"),
                .product(name: "Cordova", package: "capacitor-swift-pm")
            ],
            path: "ios/Sources/CopyAndroidPlugin"),
        .testTarget(
            name: "CopyAndroidPluginTests",
            dependencies: ["CopyAndroidPlugin"],
            path: "ios/Tests/CopyAndroidPluginTests")
    ]
)