package dev.yjyoon.template.buildlogic.convention

import dev.yjyoon.template.buildlogic.convention.extension.android
import dev.yjyoon.template.buildlogic.convention.extension.implementation
import dev.yjyoon.template.buildlogic.convention.extension.kotlinAndroidOptions
import dev.yjyoon.template.buildlogic.convention.extension.library
import dev.yjyoon.template.buildlogic.convention.extension.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

@Suppress("unused")
class AndroidKotlinPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("org.jetbrains.kotlin.android")
            }
            tasks.withType(KotlinCompile::class.java) {
                compilerOptions {
                    // Treat all Kotlin warnings as errors (disabled by default)
                    allWarningsAsErrors.set(properties["warningsAsErrors"] as? Boolean ?: false)
                    freeCompilerArgs.addAll(
                        listOf(
                            "-opt-in=kotlin.RequiresOptIn",
                        ),
                    )
                    jvmTarget.set(JvmTarget.JVM_17)
                }
            }

            android {
                kotlinAndroidOptions {
                    compilerOptions {
                        jvmTarget.set(JvmTarget.JVM_17)
                    }
                }
            }
            dependencies {
                implementation(libs.library("coroutines-core"))
            }
        }
    }
}
