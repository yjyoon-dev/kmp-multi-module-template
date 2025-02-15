plugins {
    id("template.convention.lint")
    id("template.convention.kmp")
    id("template.convention.kmp.android")
    id("template.convention.kmp.ios")
    id("template.convention.kmp.compose")
}

android.namespace = "dev.yjyoon.template.core.designsystem"

compose.resources {
    publicResClass = true
}
