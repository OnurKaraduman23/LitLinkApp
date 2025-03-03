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
include(":navigation")

include(":feature:home")
include(":feature:onboarding")
include(":feature:favorites")
include(":feature:search")
include(":feature:detail")
include(":feature:profile")
include(":feature:discover")
include(":feature:home:data")
include(":feature:home:ui")
include(":feature:home:domain")
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
include(":feature:discover:data")
include(":feature:discover:domain")
include(":feature:discover:ui")
include(":feature:splash")
include(":feature:login")
include(":feature:register")
include(":feature:splash:data")
include(":feature:splash:domain")
include(":feature:splash:ui")

include(":core:common")
include(":core:connectivity")
include(":core:network")
include(":core:ui")
include(":core:datasource")
include(":core:datastore")
include(":feature:login:data")
include(":feature:login:domain")
include(":feature:login:ui")
include(":feature:register:data")
include(":feature:register:domain")
include(":feature:register:ui")
