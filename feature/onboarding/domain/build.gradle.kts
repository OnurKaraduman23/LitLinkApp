plugins {
    alias(libs.plugins.litlink.jvm.library)
}

group = "com.litlink.feature.onboarding.domain"
dependencies {
    implementation(projects.core.common)
    implementation(libs.javax.inject) //Inject i sağlıyor
}