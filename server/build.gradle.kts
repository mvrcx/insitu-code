import org.jetbrains.dokka.gradle.DokkaTask

plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("org.jetbrains.dokka")
}

kotlin {

    jvm()

    /**
     *
     * KTOR SERVER IS NOT YET MP READY! ONLY JAVA
     * https://ktor.io/
     *
     * */

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(":shared"))
            }
        }

        val jvmMain by getting {
            dependencies {
                implementation(Dependencies.Koin.ktor)
                implementation(Dependencies.Ktor.clientCore)
                implementation(Dependencies.Ktor.clientCIO)
                implementation(Dependencies.Ktor.clientContentNegotiation)
                implementation(Dependencies.Ktor.clientLogging)
                implementation(Dependencies.Ktor.serverCore)
                implementation(Dependencies.Ktor.serverCIO)
                implementation(Dependencies.Ktor.serverStatusPages)
                implementation(Dependencies.Ktor.serverDefaultHeaders)
                implementation(Dependencies.Ktor.logging)
                implementation(Dependencies.Ktor.serverContentNegotiation)
                implementation(Dependencies.Ktor.serializationKotlinxJson)
                implementation(Dependencies.Ktor.serverAuth) // Java only
                implementation(Dependencies.Ktor.serverHtmlBuilder) // Java only
                implementation(Dependencies.Ktor.serverSessions) // Java only
                implementation(Dependencies.Ktor.serverAuthJwt)

                implementation(files("libs/onnxruntime-1.11.0.jar"))
                implementation("org.jetbrains.kotlinx:kotlin-deeplearning-api:0.3.0")
                implementation("org.jetbrains.kotlinx:kotlin-deeplearning-onnx:0.3.0")
                implementation ("org.jetbrains.kotlinx:kotlin-deeplearning-visualization:0.3.0")
            }
        }
    }
}

tasks.withType<DokkaTask>().configureEach {
    // custom output directory
    outputDirectory.set(buildDir.resolve("dokka"))
}


