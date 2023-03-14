import org.jetbrains.dokka.gradle.DokkaTask

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
    id("org.jetbrains.dokka")
}

kotlin {
    js(IR) {
        binaries.executable()
        browser {
            commonWebpackConfig {
                cssSupport.enabled = true
            }
        }
    }
    sourceSets {

        val jsMain by getting {
            dependencies {
                //implementation(project(":shared")) // <--- can not be used because database only supports KMM (not KMP incl. js and native)
                // use this:
//                implementation(project(":composables"))
                // instead of these when namespaces are harmonised
                implementation(compose.web.core)
                implementation(compose.runtime)
            }
        }

        val jsTest by getting
    }
}

tasks.withType<DokkaTask>().configureEach {
    // custom output directory
    outputDirectory.set(buildDir.resolve("dokka"))
}