plugins {
    kotlin("multiplatform") version Versions.kotlin apply false
    kotlin("plugin.serialization") version  Versions.kotlin apply false
    id("org.jetbrains.compose") version  Versions.jetbrainsCompose apply false
    id("org.jetbrains.dokka") version  Versions.dokka apply false
    id("com.android.application") version Versions.gradle apply false
    id("com.android.library") version Versions.gradle apply false
}

// On Apple Silicon we need Node.js 16.0.0
// https://youtrack.jetbrains.com/issue/KT-49109
rootProject.plugins.withType<org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootPlugin> {
    rootProject.the<org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension>().nodeVersion = "16.0.0"
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions.freeCompilerArgs += "-Xopt-in=kotlin.RequiresOptIn"
}

// 'compileJava' task (current target is 17) and 'compileKotlin' task (current target can be set here) jvm target compatibility should be set to the same Java version.
tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = Versions.jvmTarget
    }
}

//tasks.register("clean", Delete::class) {
//    delete(rootProject.buildDir)
//}