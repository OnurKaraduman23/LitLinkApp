plugins {
    alias(libs.plugins.litlink.jvm.library)
}

group = "com.litlink.feature.search.domain"
dependencies {
    implementation(projects.core.common)
    implementation(libs.javax.inject)
}