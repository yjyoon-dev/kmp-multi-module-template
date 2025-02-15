plugins {
    id("template.convention.lint")
    id("template.convention.kmp")
    id("template.convention.kmp.android")
    id("template.convention.kmp.ios")
    id("template.convention.kotlin.serialization")
}

android.namespace = "dev.yjyoon.template.core.network"

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(libs.kotlinx.datetime)
            api(projects.core.common)
            api(projects.core.model)

            implementation(libs.bundles.ktor)
            implementation(libs.koin.core)
        }
        androidMain.dependencies {
            implementation(libs.ktor.client.android)
        }
        iosMain.dependencies {
            implementation(libs.ktor.client.darwin)
        }
    }
}
