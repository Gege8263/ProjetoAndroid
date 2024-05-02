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
    versionCatalogs {
        create("androidx") {

            "appcompat" to "1.6.1"
            "material" to "1.10.0"
            "constraintlayout" to "2.1.4"
            "lifecycle_viewmodel" to "2.7.0"
            "lifecycle_runtime" to "2.7.0"
            "sqlite" to "2.4.0"
            "junit" to "4.13.2"
            "espresso_core" to "3.4.0"
            "test_ext_junit" to "1.1.3"
        }
    }
}


rootProject.name = "My Application"
include(":app")
