package com.onuryasarkaraduman

import com.onuryasarkaraduman.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class RetrofitConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("org.jetbrains.kotlin.plugin.serialization")
            dependencies {
                "api"(libs.findLibrary("retrofit").get())
                "implementation"(libs.findLibrary("kotlinx.serialization").get())
                "implementation"(libs.findLibrary("converter.gson").get())
            }
        }
    }
}
