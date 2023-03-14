import org.jetbrains.dokka.gradle.DokkaTask

plugins {
    id("com.android.library")
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("org.jetbrains.dokka")
}

kotlin {

    android()

//    listOf(
//        iosX64(),
//        iosArm64(),
//        //iosSimulatorArm64() // make sure all ios dependencies support this target
//    ).forEach {
//        it.binaries.framework {
//            baseName = "model"
//        }
//    }

//    js(IR) { // TODO activate when ready to start implementing
//        binaries.executable()
//        browser {
//            commonWebpackConfig {
//                cssSupport.enabled = true
//            }
//        }
//    }

//    jvm() // TODO activate when ready to start implementing

    sourceSets {
        all {
            languageSettings.optIn("kotlin.RequiresOptIn")
        }
        val commonMain by getting {
            dependencies {
                //implementation(Dependencies.kotlin)
                implementation(Dependencies.datetime)
                implementation(Dependencies.serializationJson)
                // https://mvnrepository.com/artifact/org.jetbrains.kotlin/kotlin-script-runtime
                //implementation(Dependencies.kotlinScript)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(Dependencies.jtsCore)
            }
        }
        val androidTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation(Dependencies.Test.junit)
            }
        }

//        val iosX64Main by getting
//        val iosArm64Main by getting
//        //val iosSimulatorArm64Main by getting
//        val iosMain by creating {
//            dependsOn(commonMain)
//            iosX64Main.dependsOn(this)
//            iosArm64Main.dependsOn(this)
//            //iosSimulatorArm64Main.dependsOn(this)
//        }
//        val iosX64Test by getting
//        val iosArm64Test by getting
//        //val iosSimulatorArm64Test by getting
//        val iosTest by creating {
//            dependsOn(commonTest)
//            iosX64Test.dependsOn(this)
//            iosArm64Test.dependsOn(this)
//           // iosSimulatorArm64Test.dependsOn(this)
//        }

//        val jsMain by getting
//
//        val jsTest by getting
//
//        val jvmMain by getting
//
//        val jvmTest by getting
    }
}

android {
    compileSdk = AndroidSdk.compileSdk
    sourceSets["main"].java.srcDir("src/androidMain/kotlin")
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = AndroidSdk.minSdk
        targetSdk = AndroidSdk.targetSdk
    }
}

tasks.withType<DokkaTask>().configureEach {
    // custom output directory
    outputDirectory.set(buildDir.resolve("dokka"))
}