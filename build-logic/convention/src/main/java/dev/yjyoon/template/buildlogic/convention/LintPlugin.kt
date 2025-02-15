package dev.yjyoon.template.buildlogic.convention

import org.gradle.api.Plugin
import org.gradle.api.Project

@Suppress("unused")
class LintPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(SpotlessPlugin::class.java)
                apply(DetektPlugin::class.java)
            }
        }
    }
}
