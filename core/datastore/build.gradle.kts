plugins {
    alias(libs.plugins.litlink.android.library)
    alias(libs.plugins.litlink.hilt)
    alias(libs.plugins.kotlinx.serialization.plugin)
}

android {
    namespace = "com.onuryasarkaraduman.core.datastore"
}

dependencies {
    implementation(libs.datastore)
    implementation(libs.kotlinx.serialization)
}