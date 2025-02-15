pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "LitLinkApp"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
include(":app")
include(":feature")
include(":core")
include(":feature:home")
include(":feature:onboarding")
include(":feature:favorites")
include(":feature:search")
include(":feature:detail")
include(":feature:profile")



include(":feature:home:data")
include(":feature:home:ui")
include(":feature:home:domain")
include(":core:common")
include(":core:connectivity")
include(":core:network")
include(":core:ui")
include(":navigation")
include(":feature:onboarding:data")
include(":feature:onboarding:ui")
include(":feature:onboarding:domain")
include(":feature:favorites:data")
include(":feature:favorites:domain")
include(":feature:favorites:ui")
include(":feature:search:data")
include(":feature:search:domain")
include(":feature:search:ui")
include(":feature:detail:data")
include(":feature:detail:domain")
include(":feature:detail:ui")
include(":feature:profile:data")
include(":feature:profile:domain")
include(":feature:profile:ui")
