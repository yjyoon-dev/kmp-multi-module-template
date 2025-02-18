package dev.yjyoon.template.buildlogic.convention

import dev.yjyoon.template.buildlogic.convention.extension.kotlin
import dev.yjyoon.template.buildlogic.convention.extension.kspKmp
import dev.yjyoon.template.buildlogic.convention.extension.library
import dev.yjyoon.template.buildlogic.convention.extension.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

@Suppress("unused")
class RoomPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.google.devtools.ksp")
            }

            kotlin {
                with(sourceSets) {
                    getByName("commonMain").apply {
                        dependencies {
                            implementation(libs.library("room-runtime"))
                            implementation(libs.library("sqlite-bundled"))
                        }
                    }
                }
            }
            dependencies {
                kspKmp(libs.library("room-compiler"))
            }
        }
    }
}
