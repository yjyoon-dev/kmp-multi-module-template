package dev.yjyoon.template.buildlogic.convention

import dev.yjyoon.template.buildlogic.convention.extension.kotlin
import dev.yjyoon.template.buildlogic.convention.extension.library
import dev.yjyoon.template.buildlogic.convention.extension.libs
import org.gradle.api.Plugin
import org.gradle.api.Project

@Suppress("unused")
class KtorfitPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.google.devtools.ksp")
                apply("de.jensklingenberg.ktorfit")
            }

            kotlin {
                with(sourceSets) {
                    getByName("commonMain").apply {
                        dependencies {
                            implementation(libs.library("ktorfit"))
                        }
                    }
                }
            }
        }
    }
}
