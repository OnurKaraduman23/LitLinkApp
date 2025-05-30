plugins {
    alias(libs.plugins.litlink.android.feature)
    alias(libs.plugins.litlink.android.library.compose)
}

android {
    namespace = "com.onuryasarkaraduman.feature.discover.ui"
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation(projects.feature.discover.domain)


}
