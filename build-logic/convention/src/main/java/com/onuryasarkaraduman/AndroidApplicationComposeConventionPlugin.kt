package com.onuryasarkaraduman

import com.android.build.api.dsl.ApplicationExtension
import com.onuryasarkaraduman.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType


class AndroidApplicationComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            apply(plugin = "org.jetbrains.kotlin.plugin.compose")

            val extension = extensions.getByType<ApplicationExtension>()

            with(extension) {
                buildFeatures {
                    compose = true
                }

                dependencies {
                    val bom = libs.findLibrary("compose-bom").get()
                    "implementation"(platform(bom))
                    "implementation"(libs.findLibrary("material3").get())
                    "implementation"(libs.findLibrary("activity-compose").get()) // Eklenen satır
                    "androidTestImplementation"(platform(bom))
                    "implementation"(libs.findLibrary("compose-ui-tooling-preview").get())
                    "debugImplementation"(libs.findLibrary("compose-ui-tooling").get())
                }
            }
        }
    }
}