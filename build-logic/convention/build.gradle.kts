import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = "dev.yjyoon.template.buildlogic.convention"

repositories {
    google {
        content {
            includeGroupByRegex("com\\.android.*")
            includeGroupByRegex("com\\.google.*")
            includeGroupByRegex("androidx.*")
        }
    }
    mavenCentral()
    gradlePluginPortal()
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions.jvmTarget = "17"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    implementation(libs.bundles.plugins)
}

gradlePlugin {
    plugins {
        register("lint") {
            id = "template.convention.lint"
            implementationClass = "dev.yjyoon.template.buildlogic.convention.LintPlugin"
        }
        register("kmp") {
            id = "template.convention.kmp"
            implementationClass = "dev.yjyoon.template.buildlogic.convention.KmpPlugin"
        }
        register("kmpAndroid") {
            id = "template.convention.kmp.android"
            implementationClass = "dev.yjyoon.template.buildlogic.convention.KmpAndroidPlugin"
        }
        register("kmpIos") {
            id = "template.convention.kmp.ios"
            implementationClass = "dev.yjyoon.template.buildlogic.convention.KmpIosPlugin"
        }
        register("kmpCompose") {
            id = "template.convention.kmp.compose"
            implementationClass = "dev.yjyoon.template.buildlogic.convention.KmpComposePlugin"
        }
        register("kotlinSerialization") {
            id = "template.convention.kotlin.serialization"
            implementationClass =
                "dev.yjyoon.template.buildlogic.convention.KotlinSerializationPlugin"
        }
        register("kotlinAndroid") {
            id = "template.convention.kotlin.android"
            implementationClass = "dev.yjyoon.template.buildlogic.convention.KotlinAndroidPlugin"
        }
        register("androidApplication") {
            id = "template.convention.android.application"
            implementationClass =
                "dev.yjyoon.template.buildlogic.convention.AndroidApplicationPlugin"
        }
        register("androidLibrary") {
            id = "template.convention.android.library"
            implementationClass = "dev.yjyoon.template.buildlogic.convention.AndroidLibraryPlugin"
        }
        register("googleServices") {
            id = "template.convention.google.services"
            implementationClass = "dev.yjyoon.template.buildlogic.convention.GoogleServicesPlugin"
        }
        register("ktorfit") {
            id = "template.convention.ktorfit"
            implementationClass = "dev.yjyoon.template.buildlogic.convention.KtorfitPlugin"
        }
        register("room") {
            id = "template.convention.room"
            implementationClass = "dev.yjyoon.template.buildlogic.convention.RoomPlugin"
        }
        register("spotless") {
            id = "template.convention.spotless"
            implementationClass =
                "dev.yjyoon.template.buildlogic.convention.SpotlessConventionPlugin"
        }
        register("detekt") {
            id = "template.convention.detekt"
            implementationClass = "dev.yjyoon.template.buildlogic.convention.DetektPlugin"
        }
    }
}
