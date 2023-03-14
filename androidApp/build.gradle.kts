plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    sourceSets["main"].java.srcDir("src/main/kotlin")

    compileSdk = AndroidSdk.compileSdk
    defaultConfig {
        applicationId = AndroidSdk.applicationId
        minSdk = AndroidSdk.minSdk
        targetSdk = AndroidSdk.targetSdk
        versionCode = AndroidSdk.versionCode
        versionName = AndroidSdk.versionName
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
        }
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.kotlinCompilerExtensionVersion
    }

    kotlinOptions {
        jvmTarget = Versions.jvmTarget
    }
}

dependencies {
    // Projects
    implementation(project(":shared"))

    implementation(Dependencies.material)
    implementation(Dependencies.datetime)
    implementation(Dependencies.serializationJson)
    implementation(Dependencies.kermit)
    implementation(Dependencies.realm)
    implementation(Dependencies.osmdroid)
    // Koin
    implementation(Dependencies.Koin.android)
    implementation(Dependencies.Koin.compose)
    // AndroidX
    implementation(Dependencies.AndroidX.activityCompose)
    implementation(Dependencies.AndroidX.activityKtx)
    implementation(Dependencies.AndroidX.core)
    implementation(Dependencies.AndroidX.lifecycleViewModelCompose)
    implementation(Dependencies.AndroidX.lifecycleViewModelKtx)
    implementation(Dependencies.AndroidX.preferencesKtx)
    // CameraX
    implementation(Dependencies.CameraX.core)
    implementation(Dependencies.CameraX.camera)
    implementation(Dependencies.CameraX.lifecycle)
    implementation(Dependencies.CameraX.video)
    implementation(Dependencies.CameraX.view)
    implementation(Dependencies.CameraX.extensions)
    // Compose
    implementation(Dependencies.Compose.ui)
    implementation(Dependencies.Compose.uiTooling)
    implementation(Dependencies.Compose.materialIconsCore)
    implementation(Dependencies.Compose.materialIconsExtended)
    implementation(Dependencies.Compose.runtimeLivedata)
    implementation(Dependencies.Compose.foundation)
    implementation(Dependencies.Compose.material)
    //implementation(Dependencies.Compose.compiler)
    implementation(Dependencies.Compose.navigation)
    // Accompanist
    implementation(Dependencies.Accompanist.permissions)
    implementation(Dependencies.Accompanist.pager)
    // ExoPlayer
    implementation(Dependencies.exoplayer)
}

//tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
//    kotlinOptions {
//        freeCompilerArgs += "-opt-in=kotlin.RequiresOptIn"
//        // We probably shouldn't do this?
//        freeCompilerArgs += listOf(
//            "-P",
//            "plugin:androidx.compose.compiler.plugins.kotlin:suppressKotlinVersionCompatibilityCheck=true"
//        )
//    }
//}