plugins {
    id("template.convention.lint")
    id("template.convention.kmp")
    id("template.convention.kmp.android")
    id("template.convention.kmp.ios")
    id("template.convention.room")
}

android.namespace = "dev.yjyoon.template.core.model"

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.core.model)

            implementation(libs.kotlinx.datetime)
        }
    }
}
