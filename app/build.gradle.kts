import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    id("template.convention.lint")
    id("template.convention.kmp")
    id("template.convention.kmp.compose")
    id("template.convention.kmp.ios")
    id("template.convention.android.application")
}

android.namespace = "dev.yjyoon.template.app"

kotlin {
    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_17)
        }
    }
    targets.filterIsInstance<KotlinNativeTarget>().forEach {
        it.binaries.framework {
            baseName = "app"
            isStatic = true
            binaryOption("bundleId", "dev.yjyoon.template.app")
            binaryOption("bundleVersion", version.toString())
        }
    }

    sourceSets {
        commonMain.dependencies {
            implementation(projects.core.model)
            implementation(projects.core.data)
            implementation(projects.feature.main)
        }
        androidMain.dependencies {
            implementation(libs.androidx.activity.compose)
            implementation(libs.androidx.lifecycle.compose)
        }
    }
}
