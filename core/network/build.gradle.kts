plugins {
    alias(libs.plugins.litlink.android.library)
    alias(libs.plugins.litlink.hilt)
    alias(libs.plugins.litlink.retrofit)
    alias(libs.plugins.litlink.android.firebase)
}
android {
    namespace = "com.onuryasarkaraduman.core.network"

    defaultConfig {
        buildFeatures {
            buildConfig = true
        }

        buildConfigField(
            "String",
            "BASE_URL",
            "\"https://www.googleapis.com/books/v1/\"",
        )
        buildConfigField(
            "String",
            "API_KEY",
            "\"AIzaSyAS0rskkHYoltc-F4OnsBMitjDgLnktjEY\""
        )

    }
}

dependencies {
    implementation(projects.core.common)
    implementation(projects.core.datastore)
}