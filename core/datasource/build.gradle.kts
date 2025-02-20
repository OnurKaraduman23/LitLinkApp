plugins {
    alias(libs.plugins.litlink.android.library)
    alias(libs.plugins.litlink.hilt)
    alias(libs.plugins.litlink.retrofit)
}

android {
    namespace = "com.onuryasarkaraduman.core.datasource"
}

dependencies {

    implementation(projects.core.network)
    implementation(projects.core.common)
    implementation(projects.core.ui)

}