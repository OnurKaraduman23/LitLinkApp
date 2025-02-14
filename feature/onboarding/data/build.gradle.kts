plugins {
    alias(libs.plugins.litlink.android.library)
    alias(libs.plugins.litlink.hilt)
    alias(libs.plugins.litlink.retrofit)
}

android {
    namespace = "com.litlink.feature.onboarding.data"
}

dependencies {

    implementation(projects.feature.onboarding.domain)
    implementation(projects.core.network)
    implementation(projects.core.common)


}