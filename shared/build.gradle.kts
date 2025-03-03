import com.vanniktech.maven.publish.SonatypeHost
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.vanniktech.mavenPublish)
}

group = "io.github.msventurini"
version = "0.1.0"

kotlin {
    androidTarget {
        publishLibraryVariants("release")
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilations.all {
            compileTaskProvider.configure {
                compilerOptions {
                    jvmTarget.set(JvmTarget.JVM_1_8)
                }
            }
        }
    }
    
    val xcf = XCFramework()
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            xcf.add(this)
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            //put your multiplatform dependencies here
            implementation(libs.ktor.client.core)
            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.ktor.serialization.kotlinx.json)
            implementation(libs.ktor.client.content.negotiation)
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
//    namespace = "com.msventurini.ventukitnetworking"
    namespace = "io.github.msventurini.ventukitnetworking"
    compileSdk = 35
    defaultConfig {
        minSdk = 35
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

mavenPublishing {
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)

    signAllPublications()

    coordinates(group.toString(), "ventukitnetworking", version.toString())

    pom {
        name = "VentuKitNetworking"
        description = "Multiplatform networking module."
        inceptionYear = "2025"
        url = "https://github.com/msventurini/VentuKitNetworking"
        licenses {
            license {
                name ="GNU Lesser General Public license, Version 2.1"
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