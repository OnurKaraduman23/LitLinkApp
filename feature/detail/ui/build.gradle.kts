plugins {
    alias(libs.plugins.litlink.android.feature)
    alias(libs.plugins.litlink.android.library.compose)
    alias(libs.plugins.litlink.android.firebase)
}

android {
    namespace = "com.onuryasarkaraduman.feature.detail.ui"
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation(projects.feature.detail.domain)
    implementation(projects.core.network)
    implementation(projects.core.datasource)
}
