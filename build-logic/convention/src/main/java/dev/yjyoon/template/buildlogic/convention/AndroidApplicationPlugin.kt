package dev.yjyoon.template.buildlogic.convention

import com.android.build.api.dsl.CommonExtension
import dev.yjyoon.template.buildlogic.convention.extension.android
import dev.yjyoon.template.buildlogic.convention.extension.androidApplication
import dev.yjyoon.template.buildlogic.convention.extension.library
import dev.yjyoon.template.buildlogic.convention.extension.libs
import dev.yjyoon.template.buildlogic.convention.extension.version
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

@Suppress("unused")
class AndroidApplicationPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
            }

            androidApplication {
                android {
                    namespace?.let { this.namespace = it }
                    compileSdkVersion(libs.version("compileSdk").toInt())
                    defaultConfig {
                        applicationId = "dev.yjyoon.template"
                        minSdk = libs.version("minSdk").toInt()
                        targetSdk = libs.version("targetSdk").toInt()
                        versionCode = libs.version("versionCode").toInt()
                        versionName = libs.version("versionName")
                    }
                    buildFeatures {
                        compose = true
                    }
                    composeOptions {
                        kotlinCompilerExtensionVersion = libs.version("compose")
                    }
                    packaging {
                        resources {
                            excludes +=
                                listOf(
                                    "/META-INF/{AL2.0,LGPL2.1}",
                                    "META-INF/INDEX.LIST",
                                )
                        }
                    }
                    buildTypes {
                        getByName("release") {
                            isMinifyEnabled = false
                        }
                    }
                    compileOptions {
                        isCoreLibraryDesugaringEnabled = true
                        sourceCompatibility = JavaVersion.VERSION_17
                        targetCompatibility = JavaVersion.VERSION_17
                    }
                }
                dependencies {
                    add("coreLibraryDesugaring", libs.library("android-desugar"))
                }
                testOptions {
                    unitTests {
                        isIncludeAndroidResources = true
                    }
                }

                (this as CommonExtension<*, *, *, *, *, *>).lint {
                    // shell friendly
                    val filename = displayName.replace(":", "_").replace("[\\s']".toRegex(), "")

                    xmlReport = true
                    xmlOutput =
                        rootProject.layout.buildDirectory.file("lint-reports/lint-results-$filename.xml")
                            .get().asFile

                    htmlReport = true
                    htmlOutput =
                        rootProject.layout.buildDirectory.file("lint-reports/lint-results-$filename.html")
                            .get().asFile

                    // for now
                    sarifReport = false
                }
            }
        }
    }
}
