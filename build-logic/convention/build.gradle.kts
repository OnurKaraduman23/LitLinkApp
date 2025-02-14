import org.gradle.kotlin.dsl.compileOnly
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
plugins {
    `kotlin-dsl`
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

allprojects {
    tasks.withType<KotlinCompile>().configureEach {
        kotlinOptions {
            jvmTarget = "17"
        }
    }
}
dependencies {
    compileOnly(libs.android.plugin)
    compileOnly(libs.compose.plugin)
    compileOnly(libs.kotlin.plugin)
    compileOnly(libs.ksp.plugin)
}
gradlePlugin {
    plugins {
        register("androidApplicationCompose") {
            id = libs.plugins.litlink.android.application.compose.get().pluginId
            implementationClass = "com.onuryasarkaraduman.AndroidApplicationComposeConventionPlugin"
        }
        register("androidApplication") {
            id = libs.plugins.litlink.android.application.asProvider().get().pluginId
            implementationClass = "com.onuryasarkaraduman.AndroidApplicationConventionPlugin"
        }
        register("androidLibraryCompose") {
            id = libs.plugins.litlink.android.library.compose.get().pluginId
            implementationClass = "com.onuryasarkaraduman.AndroidLibraryComposeConventionPlugin"
        }
        register("androidLibrary") {
            id = libs.plugins.litlink.android.library.asProvider().get().pluginId
            implementationClass = "com.onuryasarkaraduman.AndroidLibraryConventionPlugin"
        }
        register("androidFeature") {
            id = libs.plugins.litlink.android.feature.get().pluginId
            implementationClass = "com.onuryasarkaraduman.AndroidFeatureConventionPlugin"
        }
        register("hilt") {
            id = libs.plugins.litlink.hilt.get().pluginId
            implementationClass = "com.onuryasarkaraduman.HiltConventionPlugin"
        }
        register("retrofit") {
            id = libs.plugins.litlink.retrofit.get().pluginId
            implementationClass = "com.onuryasarkaraduman.RetrofitConventionPlugin"
        }
        register("jvmLibrary") {
            id = libs.plugins.litlink.jvm.library.get().pluginId
            implementationClass = "com.onuryasarkaraduman.JvmLibraryConventionPlugin"
        }
    }
}