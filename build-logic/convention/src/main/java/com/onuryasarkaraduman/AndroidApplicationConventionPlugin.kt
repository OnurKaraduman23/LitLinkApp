package com.onuryasarkaraduman

import com.android.build.api.dsl.ApplicationExtension
import com.onuryasarkaraduman.convention.Versions

import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")

            }

            extensions.configure<ApplicationExtension> {
                compileSdk = Versions.COMPILE_SDK

                defaultConfig {
                    minSdk = Versions.MIN_SDK
                }

                compileOptions {
                    sourceCompatibility = JavaVersion.VERSION_17
                    targetCompatibility = JavaVersion.VERSION_17
                }
                defaultConfig.targetSdk = Versions.TARGET_SDK
            }
        }
    }
}