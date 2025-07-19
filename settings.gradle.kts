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
    repositories {
        maven {
            url = uri("https://jitpack.io")
            credentials {
                username = System.getenv("JITPACK_USERNAME")
                password = System.getenv("JITPACK_PASSWORD")
            }
        }
    }
}




    rootProject.name = "dronetestnew"
include(":app")
