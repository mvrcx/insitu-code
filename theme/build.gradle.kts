import org.jetbrains.dokka.gradle.DokkaTask

plugins {
    id("com.android.library")
    kotlin("multiplatform")
    id("org.jetbrains.compose")
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
//            baseName = "theme"
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

//    jvm()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.material)
            }
        }

        val commonTest by getting {
            dependencies {
            }
        }
        val androidMain by getting {
            dependencies {
            }
        }
        val androidTest by getting {
            dependencies {
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
//            dependencies {
//            }
//        }
//        val iosX64Test by getting
//        val iosArm64Test by getting
//        //val iosSimulatorArm64Test by getting
//        val iosTest by creating {
//            dependsOn(commonTest)
//            iosX64Test.dependsOn(this)
//            iosArm64Test.dependsOn(this)
//            //iosSimulatorArm64Test.dependsOn(this)
//        }

//        val jsMain by getting {
//            dependencies {
//            }
//        }

//        val jsTest by getting

//        val jvmMain by getting {
//            dependencies {
//                implementation(compose.desktop.currentOs)
//            }
//        }
//
//        val jvmTest by getting
    }
}

// TODO needs => compose version 1.2.0
//compose {
//    kotlinCompilerPlugin.set(Versions.AndroidX.composeCompiler)
//}

android {
    compileSdk = AndroidSdk.compileSdk
    sourceSets["main"].java.srcDir("src/androidMain/kotlin")
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/commonMain/res")
    defaultConfig {
        minSdk = AndroidSdk.minSdk
        targetSdk = AndroidSdk.targetSdk
    }
}

tasks.withType<DokkaTask>().configureEach {
    // custom output directory
    outputDirectory.set(buildDir.resolve("dokka"))
}