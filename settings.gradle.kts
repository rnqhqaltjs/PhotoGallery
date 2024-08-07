pluginManagement {
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


rootProject.name = "PhotoGallery"
include(":app")

// core
include(":core:data")
include(":core:domain")

// Feature
include(":feature:home")
include(":feature:randomphoto")
include(":feature:detail")
include(":core:designsystem")
include(":core:common")
include(":core:network")
include(":core:database")
include(":core:model")
