plugins {
    alias(libs.plugins.litlink.jvm.library)
}

group = "com.litlink.feature.discover.domain"
dependencies {
    implementation(projects.core.common)
    implementation(libs.javax.inject)
}