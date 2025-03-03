import com.vanniktech.maven.publish.SonatypeHost

plugins {
    //trick: for the same plugin versions in all sub-modules
    alias(libs.plugins.androidLibrary).apply(false)
    alias(libs.plugins.kotlinMultiplatform).apply(false)
    alias(libs.plugins.compose.compiler).apply(false)

    id("com.vanniktech.maven.publish") version "0.30.0"

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