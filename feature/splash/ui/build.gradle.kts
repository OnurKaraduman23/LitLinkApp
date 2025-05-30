plugins {
    alias(libs.plugins.litlink.android.feature)
    alias(libs.plugins.litlink.android.library.compose)
}

android {
    namespace = "com.onuryasarkaraduman.feature.splash.ui"
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation(projects.feature.splash.domain)
    implementation(projects.core.network)
    implementation(projects.core.datastore)
    implementation(projects.core.datasource)
    implementation(libs.lottie.animation)


}
