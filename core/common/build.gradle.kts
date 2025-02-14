plugins {
    alias(libs.plugins.litlink.jvm.library)
    id("org.jetbrains.kotlin.plugin.compose")
}
group = "com.onuryasarkaraduman.core.common"
dependencies {
    implementation(platform(libs.compose.bom))
    implementation(libs.material3)
    implementation(libs.lifecycle.runtime.compose)
}