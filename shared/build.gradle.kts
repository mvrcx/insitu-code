import org.jetbrains.dokka.gradle.DokkaTask

plugins {
    id("com.android.library")
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("io.realm.kotlin") version Versions.realm
    id("org.jetbrains.dokka")
    id("org.jetbrains.compose")
}

kotlin {

    android()
    
//    listOf(
//        iosX64(),
//        iosArm64(),
//        //iosSimulatorArm64() // make sure all ios dependencies support this target
//    ).forEach {
//        it.binaries.framework {
//            baseName = "shared"
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

//    jvm() // needed by server module // TODO activate when ready to start implementing

    sourceSets {
        all {
            languageSettings.optIn("kotlin.RequiresOptIn")
        }
        val commonMain by getting {
            dependencies {
                api(project(":model"))
                api(project(":theme"))
                implementation(Dependencies.datetime)
                implementation(Dependencies.coroutines)
                implementation(Dependencies.serializationJson)
                implementation(Dependencies.kermit)
                implementation(Dependencies.Koin.core)
                //implementation(Dependencies.Koin.ktor) // not working with ios
                implementation(Dependencies.Ktor.clientAuth)
                implementation(Dependencies.Ktor.clientCore)
                implementation(Dependencies.Ktor.clientLogging)
                implementation(Dependencies.Ktor.clientSerialization)
                implementation(Dependencies.Ktor.clientContentNegotiation)
                implementation(Dependencies.Ktor.serializationKotlinxJson)
                implementation(Dependencies.realm)

                // Compose is needed for shared resources
                implementation(compose.material)
                implementation(compose.materialIconsExtended) //<-- DOES NOT WORK WITH JS TARGET CURRENTLY
                // Reason: There are no JS-artifacts
                // Workaround: manually using an older version instead
                //implementation("org.jetbrains.compose.material:material-icons-extended:1.1.1")
            }
        }
        val commonTest by getting {
            dependencies {
              //  implementation(kotlin("test-common"))
              //  implementation(kotlin("test-annotations-common"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(Dependencies.AndroidX.exifinterface)
                implementation(Dependencies.Koin.android)
                //implementation(Dependencies.Ktor.clientAuth)
                //implementation(Dependencies.Koin.workManager)
                implementation(Dependencies.Koin.navigation)
                //implementation(Dependencies.Koin.compose)
                implementation(Dependencies.Ktor.logging)
                implementation(Dependencies.Ktor.clientCIO)
                implementation(Dependencies.couchbaseLite)
                implementation(Dependencies.osmdroid)
            }
        }

//        val androidAndroidTestRelease by getting
//        val androidTestFixtures by getting
//        val androidTestFixturesDebug by getting
//        val androidTestFixturesRelease by getting
        val androidTest by getting {
//            dependsOn(commonTest)
//            androidAndroidTestRelease.dependsOn(this)
//            androidTestFixtures.dependsOn(this)
//            androidTestFixturesDebug.dependsOn(this)
//            androidTestFixturesRelease.dependsOn(this)
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
//            dependencies {
//                implementation(Dependencies.Ktor.clientIOS)
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
//
//        val jsTest by getting

//        val jvmMain by getting {
//            dependencies {
//                //implementation(Dependencies.Ktor.serverAuthJwt)
//                implementation(Dependencies.Ktor.clientCIO)
//            }
//        }
//
//        val jvmTest by getting
    }
}

// This is a KMP Compose option! works from kotlin 1.7.20 on
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

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.kotlinCompilerExtensionVersion
    }
}

tasks.withType<DokkaTask>().configureEach {
    // custom output directory
    outputDirectory.set(buildDir.resolve("dokka"))
}