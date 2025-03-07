plugins {
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.kotlinMultiplatform) apply  false
    alias(libs.plugins.vanniktech.mavenPublish) apply false
    id("co.touchlab.skie") version "0.10.1" apply false
    kotlin("plugin.serialization") version "2.1.10"

}