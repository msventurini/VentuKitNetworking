import co.touchlab.skie.configuration.SuppressSkieWarning
import com.vanniktech.maven.publish.SonatypeHost
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.vanniktech.mavenPublish)
    id("co.touchlab.skie")

}

group = "io.github.msventurini"
version = "0.0.7"

kotlin {

    androidTarget {
        publishLibraryVariants("release")
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    val xcframeworkName = "VentuKitNetworking"
    val xcf = XCFramework(xcframeworkName)

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64(),
    ).forEach {
        it.binaries.framework {
            baseName = xcframeworkName

            binaryOption("bundleId", "org.msventurini.${xcframeworkName}")
            xcf.add(this)
            isStatic = true
        }
    }

    sourceSets {

        commonMain.dependencies {
            implementation(libs.ktor.client.core)
            implementation(libs.kotlinx.coroutines.core)
            implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.8.0")

        }

        androidMain.dependencies {
            implementation(libs.ktor.client.okhttp)
        }

        iosMain.dependencies {
            implementation(libs.ktor.client.darwin)
        }

        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }

    }
}

android {
    namespace = "io.github.msventurini.ventukitnetworking"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

mavenPublishing {
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)

    signAllPublications()

    coordinates(group.toString(), "VentuKitNetworking", version.toString())

    pom {
        name = "VentuKitNetworking"
        description = "A networking library."
        inceptionYear = "2025"
        url = "https://github.com/msventurini/VentuKitNetworking"
        licenses {
            license {
                name = "GNU Lesser General Public license, Version 2.1"
                url = "https://www.gnu.org/licenses/old-licenses/lgpl-2.1.txt"
                distribution = "https://www.gnu.org/licenses/old-licenses/lgpl-2.1.txt"
            }
        }
        developers {
            developer {
                id = "msventurini"
                name = "Matheus Silveira Venturini"
                url = "https://github.com/msventurini/"
            }
        }
        scm {
            url = "https://github.com/msventurini/VentuKitNetworking"
            connection = "scm:git:git://github.com/msventurini/VentuKitNetworking.git"
            developerConnection = "scm:git:ssh://git@github.com/msventurini/VentuKitNetworking.git"
        }
    }
}
