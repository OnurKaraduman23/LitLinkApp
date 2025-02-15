plugins {
    alias(libs.plugins.litlink.android.library)
    alias(libs.plugins.litlink.hilt)
    alias(libs.plugins.litlink.retrofit)
}

android {
    namespace = "com.litlink.feature.favorites.data"
}

dependencies {

    implementation(projects.feature.favorites.domain)
    implementation(projects.core.network)
    implementation(projects.core.common)


}