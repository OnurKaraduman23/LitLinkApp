plugins {
    alias(libs.plugins.litlink.jvm.library)
}

group = "com.litlink.feature.home.domain"
dependencies {
//    implementation(projects.core.common)
    implementation(libs.javax.inject) //Inject i sağlıyor
//    implementation(libs.kotlinx.coroutines.core)
}