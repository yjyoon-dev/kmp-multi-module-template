package dev.yjyoon.template.buildlogic.convention

import dev.yjyoon.template.buildlogic.convention.extension.android
import dev.yjyoon.template.buildlogic.convention.extension.configureAndroid
import dev.yjyoon.template.buildlogic.convention.extension.kotlin
import dev.yjyoon.template.buildlogic.convention.extension.libraryAndroidOptions
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

@Suppress("unused")
class KmpAndroidPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
            }
            kotlin {
                androidTarget {
                    compilations.all {
                        libraryAndroidOptions {
                            compileTaskProvider.configure {
                                compilerOptions {
                                    jvmTarget.set(JvmTarget.JVM_17)
                                }
                            }
                        }
                    }
                }
            }
            android {
                configureAndroid()
            }
        }
    }
}
