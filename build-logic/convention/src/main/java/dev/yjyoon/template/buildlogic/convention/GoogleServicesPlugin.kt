package dev.yjyoon.template.buildlogic.convention

import org.gradle.api.Plugin
import org.gradle.api.Project

@Suppress("unused")
class GoogleServicesPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.google.gms.google-services")
            }
        }
    }
}
