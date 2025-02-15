plugins {
    id("template.convention.lint")
    id("template.convention.kmp")
    id("template.convention.kmp.android")
    id("template.convention.kmp.ios")
    id("template.convention.kmp.compose")
}

android.namespace = "dev.yjyoon.template.core.ui"

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.core.designsystem)
            api(projects.core.model)

            implementation(libs.coil.compose)
            implementation(libs.coil.ktor)

            implementation(libs.ktor.client)
            implementation(libs.ktor.client.auth)
        }
    }
}
