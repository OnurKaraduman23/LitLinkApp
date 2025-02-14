plugins {
    alias(libs.plugins.litlink.android.application)
    alias(libs.plugins.litlink.android.application.compose)
    alias(libs.plugins.litlink.hilt)
}

android {
    namespace = "com.onuryasarkaraduman.litlinkapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.onuryasarkaraduman.litlinkapp"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

}

dependencies {


}