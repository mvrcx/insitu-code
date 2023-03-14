pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_PROJECT)
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven("https://mobile.maven.couchbase.com/maven2/dev/")
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

rootProject.name = "insitu"
include(":androidApp")
//include(":webApp") // TODO activate when ready to start implementing
include(":shared")
include(":model")
include(":theme")
//include(":server") // TODO activate when ready to start implementing
