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
    implementation(projects.feature.detail.ui)
    implementation(projects.feature.favorites.ui)
    implementation(projects.feature.search.ui)
    implementation(projects.feature.profile.ui)
    implementation(projects.feature.discover.ui)
    implementation(projects.feature.onboarding.ui)
    implementation(projects.feature.splash.ui)

    implementation(projects.core.ui)

    implementation(libs.navigation.compose)
    implementation(libs.kotlinx.serialization)
}