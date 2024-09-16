pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        //START SPLASH SCREEN
        maven(url = "https://jitpack.io")
        //END SPLASH SCREEN
    }
}

rootProject.name = "SPScontactos"
include(":app")
