package dev.yjyoon.template.buildlogic.convention

import dev.yjyoon.template.buildlogic.convention.extension.android
import dev.yjyoon.template.buildlogic.convention.extension.compose
import dev.yjyoon.template.buildlogic.convention.extension.composeCompiler
import dev.yjyoon.template.buildlogic.convention.extension.kotlin
import dev.yjyoon.template.buildlogic.convention.extension.library
import dev.yjyoon.template.buildlogic.convention.extension.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.jetbrains.kotlin.compose.compiler.gradle.ComposeFeatureFlag

@Suppress("unused")
class KmpComposePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("org.jetbrains.compose")
                apply("org.jetbrains.kotlin.plugin.compose")
            }
            if (plugins.hasPlugin("com.android.library")) {
                android {
                    buildFeatures.compose = true
                }
            }
            composeCompiler {
                featureFlags.add(ComposeFeatureFlag.StrongSkipping)
            }
            kotlin {
                with(sourceSets) {
                    getByName("commonMain").apply {
                        dependencies {
                            implementation(compose.dependencies.runtime)
                            implementation(compose.dependencies.foundation)
                            implementation(compose.dependencies.material3)
                            implementation(compose.dependencies.ui)
                            implementation(compose.dependencies.components.resources)
                            implementation(compose.dependencies.components.uiToolingPreview)
                            implementation(libs.library("navigation-compose"))
                        }
                    }
                    find { it.name == "androidMain" }?.apply {
                        dependencies {
                            implementation(compose.dependencies.preview)
                        }
                    }
                }
            }
        }
    }
}
