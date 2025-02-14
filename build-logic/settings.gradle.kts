dependencyResolutionManagement {
    // 1. Setup repositories to download dependencies
    repositories {
        google()
        mavenCentral()
    }

    // 2. Create version catalog named `libs` from 
    // the `libs.versions.toml` file already present in
    // the gradle folder.
    versionCatalogs {
        create("libs") {
            from(files("../gradle/libs.versions.toml"))
        }
    }
}

// 3. Set project name
rootProject.name = "build-logic"
include(":convention")