plugins {
    alias(libs.plugins.litlink.android.library)
    alias(libs.plugins.litlink.hilt)
    alias(libs.plugins.litlink.retrofit)
    alias(libs.plugins.litlink.android.firebase)
}

android {
    namespace = "com.litlink.feature.splash.data"
}

dependencies {

    implementation(projects.feature.splash.domain)
    implementation(projects.core.network)
    implementation(projects.core.common)


}