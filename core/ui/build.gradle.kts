plugins {
    alias(libs.plugins.litlink.android.library)
    alias(libs.plugins.litlink.android.library.compose)
}

android {
    namespace = "com.onuryasarkaraduman.core.ui"
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
}