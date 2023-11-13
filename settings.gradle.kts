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
    }
}

rootProject.name = "Amsi"
include(":app")
include(":features")
include(":features:splash")
include(":common")
include(":features:onboarding")
include(":features:auth")
include(":picker")
include(":features:info")
include(":navigation")
include(":features:main")
include(":features:feed")
include(":features:events")
include(":features:jobs")
include(":data")
include(":domain")
include(":features:profile")
include(":features:search")
