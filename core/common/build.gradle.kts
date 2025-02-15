plugins {
    id("template.convention.lint")
    id("template.convention.kmp")
    id("template.convention.kmp.android")
    id("template.convention.kmp.ios")
}

android.namespace = "dev.yjyoon.template.core.common"

kotlin {
    sourceSets {
        commonMain.dependencies {
        }
    }
}
