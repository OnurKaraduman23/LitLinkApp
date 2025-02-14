plugins {
    alias(libs.plugins.litlink.android.library)
    alias(libs.plugins.litlink.android.library.compose)
    alias(libs.plugins.kotlinx.serialization.plugin)
}

android {
    namespace = "com.onuryasarkaraduman.navigation"

    kotlinOptions {
        jvmTarget = "17"
    }
}
dependencies {
    implementation(projects.feature.home.ui)
    implementation(projects.core.ui)

    implementation(libs.navigation.compose)
    implementation(libs.kotlinx.serialization)
}