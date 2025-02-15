package dev.yjyoon.template.buildlogic.convention

import dev.yjyoon.template.buildlogic.convention.extension.androidLibrary
import dev.yjyoon.template.buildlogic.convention.extension.configureAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project

@Suppress("unused")
class AndroidLibraryPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
            }

            androidLibrary {
                configureAndroid()
            }
        }
    }
}
