import com.vanniktech.maven.publish.SonatypeHost

plugins {
    //trick: for the same plugin versions in all sub-modules
    alias(libs.plugins.androidLibrary).apply(false)
    alias(libs.plugins.kotlinMultiplatform).apply(false)
    alias(libs.plugins.compose.compiler).apply(false)
    alias(libs.plugins.vanniktech.mavenPublish).apply(false)
    kotlin("plugin.serialization") version "2.0.0"

}