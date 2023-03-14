object AndroidSdk {
    const val applicationId = "p20.insitu.android"
    const val minSdk = 31
    const val targetSdk = 32
    const val compileSdk = targetSdk
    const val buildTools = ""
    const val versionCode = 112 // versionCode = versionName without the dots
    const val versionName = "0.1.12"
}

/////////////////////////////
///                       ///
///     !!! CAUTION !!!   ///
///                       ///
///  These Libs must be   ///
///  updated TOGETHER!    ///
///                       ///
///        kotlin (KMP)   ///
/// jetbrainsCompose (KMP)///
///   compose (Android)   ///
/// accompanist (Android) ///
///                       ///
/////////////////////////////
// https://developer.android.com/jetpack/androidx/releases/compose-kotlin
// https://github.com/JetBrains/compose-jb/releases

object Versions {
    // ---- Gradle ---- //
    const val gradle = "7.1.3" // https://developer.android.com/studio/releases/gradle-plugin

    //********************************************************//
    //*************    KOTLIN MULTIPLATFORM    ***************//
    //********************************************************//
    // ---- Kotlin ---- //
    const val kotlin = "1.6.21" // https://kotlinlang.org/docs/releases.html#release-details
    const val jvmTarget = "1.8"

    // DO ONLY UPGRADE TOGETHER with COMPOSE (https://github.com/JetBrains/compose-jb/blob/master/VERSIONING.md#kotlin-compatibility
    // https://developer.android.com/jetpack/androidx/versions/all-channel)
    // 1.70.20 not compatible with JS !!!
    // We use Jetbrains Compose for common stuff, an specific Jetpack Compose things for some Android things (since they are not yet available as Jetbrains Compose Library contents).
    // To compile things, the AndroidX Compose Compiler is used.
    // Pay attention to the compose compiler version! It needs to be compatible to the kotlin version. https://androidx.dev/storage/compose-compiler/repository
    const val datetime = "0.3.1" // https://github.com/Kotlin/kotlinx-datetime/releases
    const val coroutines = "1.6.2" // https://github.com/Kotlin/kotlinx.coroutines
    const val serialization = "1.3.3" // https://github.com/Kotlin/kotlinx.serialization/releases
    const val koin = "3.2.2" // https://github.com/InsertKoinIO/koin
    const val koinKtor = "3.2.2" // https://github.com/InsertKoinIO/koin
    const val koinAndroid = "3.2.0" // https://github.com/InsertKoinIO/koin
    const val koinAndroidCompose = "3.2.1" // https://github.com/InsertKoinIO/koin
    const val ktor = "2.0.2" // https://github.com/ktorio/ktor // https://api.ktor.io/
    const val kotlinxHtml = "0.8.0"// https://github.com/Kotlin/kotlinx.html

    // ---- Jetbrains Compose Multiplatform ---- //
    const val jetbrainsCompose = "1.2.0-alpha01-dev729" // https://github.com/JetBrains/compose-jb/releases

    // ---- Third Party ---- //
    // KMP Logging utility
    const val kermit = "1.1.3"  // https://github.com/touchlab/Kermit/releases

    // ---- Dokka ---- //
    const val dokka = "1.6.21" // https://github.com/Kotlin/dokka/releases

    // KMM database API (local storage database, e.g. settings, catalog data)
    // Does not support native or js targets!!!
    const val realm = "1.0.0" // https://github.com/realm/realm-kotlin

    //********************************************************//
    //*************     PLATFORM: ANDROID      ***************//
    //********************************************************//
    const val kotlinCompilerExtensionVersion =
        AndroidX.composeCompiler //AndroidX.compose // build gradle compose option

    // ---- Android JETPACK ---- //
    object AndroidX {
        // Check for latest releases here: https://developer.android.com/jetpack/androidx/versions/all-channel
        // Before upgrading the compose version check compatibility with kotlin version:
        // https://developer.android.com/jetpack/androidx/releases/compose-kotlin
        const val compose =
            "1.2.0-rc02" // https://developer.android.com/jetpack/androidx/releases/compose

        // TODO when finally upgrading kotlin, replace this with the actual version and activate optionin gradle files (model, theme, shared)
        const val composeCompiler = compose // https://developer.android.com/jetpack/androidx/releases/compose-compiler
        const val composeNavigation =
            "2.4.2" // https://developer.android.com/jetpack/compose/navigation
        const val activity =
            "1.4.0" // https://developer.android.com/jetpack/androidx/releases/activity
        const val camera = "1.1.0" // https://developer.android.com/jetpack/androidx/releases/camera
        const val core = "1.8.0" // https://developer.android.com/jetpack/androidx/releases/core
        const val lifecycle =
            "2.4.1" // https://developer.android.com/jetpack/androidx/releases/lifecycle
        const val preferences =
            "1.2.0" // https://developer.android.com/jetpack/androidx/releases/preference#kts
        const val exifinterface =
            "1.3.5" // https://developer.android.com/jetpack/androidx/releases/exifinterface
    }

    // ---- Third Party ---- //
    // Utils for Jetpack Compose (Permissions, Drawable Painter...)
    const val accompanist = "0.24.12-rc" // https://github.com/google/accompanist/releases

    // The JTS Topology Suite is a Java library for creating and manipulating vector geometry.
    const val jtsCore = "1.18.2" // https://github.com/locationtech/jts/releases

    // Logging framework
    const val logback = "1.2.11" // https://logback.qos.ch/news.html

    // Material Design
    const val material = "1.5.0" // https://github.com/material-components/material-components-android/releases

    // Couchbase Lite API (documentation database)
    const val couchbaseLite =
        "3.0.0" // https://docs.couchbase.com/couchbase-lite/current/android/releasenotes.html

    // OpenStreetMap API
    const val osmdroid = "6.1.13" // https://github.com/osmdroid/osmdroid

    // ARCore
    const val arcore = "1.34.0" // https://github.com/google-ar/arcore-android-sdk/releases

    // Exoplayer
    const val exoplayer = "2.18.1" // https://github.com/google/ExoPlayer/blob/release-v2/RELEASENOTES.md

    // ---- Tests ---- //
    const val junit = "4.13.2"

}

object Gradle {
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val gradle = "com.android.tools.build:gradle:${Versions.gradle}"
}

object Dependencies {
    //********************************************************//
    //*************    KOTLIN MULTIPLATFORM    ***************//
    //********************************************************//
    // ---- Kotlin ---- //
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    const val kotlinScript = "org.jetbrains.kotlin:kotlin-script-runtime:${Versions.kotlin}"
    const val kotlinJdk8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
    const val kotlinJdk7 = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val kotlinReflect = "org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlin}"
    const val datetime = "org.jetbrains.kotlinx:kotlinx-datetime:${Versions.datetime}"
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val serializationJson =
        "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.serialization}"
    const val kotlinxHtml = "org.jetbrains.kotlinx:kotlinx-html:${Versions.kotlinxHtml}"
    const val kotlinxHtmlJvm = "org.jetbrains.kotlinx:kotlinx-html-jvm:${Versions.kotlinxHtml}"
    const val kotlinxHtmlJs = "org.jetbrains.kotlinx:kotlinx-html-js:${Versions.kotlinxHtml}"

    // Dependency Injection
    object Koin {
        const val core = "io.insert-koin:koin-core:${Versions.koin}"
        const val ktor = "io.insert-koin:koin-ktor:${Versions.koinKtor}"
        const val logger = "io.insert-koin:koin-logger-slf4j:${Versions.koin}"
        const val android = "io.insert-koin:koin-android:${Versions.koinAndroid}"

        //const val workManager = "io.insert-koin:koin-androidx-workmanager:${Versions.koin}" // ISSUE: https://stackoverflow.com/questions/68473542/mediasessioncompattargeting-s-version-31-and-above-requires-that-one-of-flag
        const val navigation = "io.insert-koin:koin-androidx-navigation:${Versions.koin}"
        const val compose =
            "io.insert-koin:koin-androidx-compose:${Versions.koinAndroidCompose}" // supports only Jetpack Compose --> not Kotlin MPP Compose
    }

    object Ktor {
        // Server
        const val serverCore = "io.ktor:ktor-server-core:${Versions.ktor}"

        // Server engines (choose one)
        const val serverNetty = "io.ktor:ktor-server-netty:${Versions.ktor}"
        const val serverJetty = "io.ktor:ktor-server-jetty:${Versions.ktor}"
        const val serverTomcat = "io.ktor:ktor-server-tomcat:${Versions.ktor}"
        const val serverCIO = "io.ktor:ktor-server-cio:${Versions.ktor}"

        // Optional server plugins
        const val serverStatusPages = "io.ktor:ktor-server-status-pages:${Versions.ktor}"
        const val serverDefaultHeaders = "io.ktor:ktor-server-default-headers:${Versions.ktor}"
        const val logging = "ch.qos.logback:logback-classic:${Versions.logback}"
        const val serverHtmlBuilder = "io.ktor:ktor-server-html-builder:${Versions.ktor}"
        const val serverAuth = "io.ktor:ktor-server-auth:${Versions.ktor}"
        const val serverAuthJwt = "io.ktor:ktor-server-auth-jwt:${Versions.ktor}"
        const val serverSessions = "io.ktor:ktor-server-sessions:${Versions.ktor}"
        const val serverContentNegotiation =
            "io.ktor:ktor-server-content-negotiation:${Versions.ktor}"

        // Clients
        const val clientCore = "io.ktor:ktor-client-core:${Versions.ktor}"
        const val clientAuth = "io.ktor:ktor-client-auth:${Versions.ktor}"
        const val clientLogging = "io.ktor:ktor-client-logging:${Versions.ktor}"
        const val clientSerialization = "io.ktor:ktor-client-serialization:${Versions.ktor}"
        const val clientContentNegotiation =
            "io.ktor:ktor-client-content-negotiation:${Versions.ktor}"

        // Client engines (choose one)
        const val clientJetty = "io.ktor:ktor-client-jetty:${Versions.ktor}"

        // CIO is a fully asynchronous coroutine-based engine that can be used for both JVM and
        // Android platforms. It supports only HTTP/1.x for now.
        const val clientCIO = "io.ktor:ktor-client-cio:${Versions.ktor}" // jvm, android
        const val clientAndroid = "io.ktor:ktor-client-android:${Versions.ktor}"
        const val clientOkHttp = "io.ktor:ktor-client-okhttp:${Versions.ktor}"
        const val clientJS = "io.ktor:ktor-client-js:${Versions.ktor}"
        const val clientCurl = "io.ktor:ktor-server-curl:${Versions.ktor}" // native

        // iOS
        const val clientIOS = "io.ktor:ktor-client-ios:${Versions.ktor}"

        // macOS
        const val clientDarwin = "io.ktor:ktor-client-darwin:${Versions.ktor}"


        const val serializationKotlinxJson =
            "io.ktor:ktor-serialization-kotlinx-json:${Versions.ktor}"
    }

    const val kermit = "co.touchlab:kermit:${Versions.kermit}"
    const val realm = "io.realm.kotlin:library-base:${Versions.realm}"

    //********************************************************//
    //*************     PLATFORM: ANDROID      ***************//
    //********************************************************//
    object Compose {
        // Transform @Composable functions and enable optimizations with a Kotlin compiler plugin.
        const val compiler =
            "androidx.compose.compiler:compiler:${Versions.AndroidX.composeCompiler}"

        // Fundamental components of compose UI needed to interact with the device, including layout,
        // drawing, and input.
        const val ui = "androidx.compose.ui:ui:${Versions.AndroidX.compose}"

        // Write Jetpack Compose applications with ready to use building blocks and extend foundation
        // to build your own design system pieces. (Border, Background, Box, Image, Scroll, shapes,
        // animations, etc.)
        const val foundation = "androidx.compose.foundation:foundation:${Versions.AndroidX.compose}"

        // Material Design: Build Jetpack Compose UIs with ready to use Material Design Components.
        // This is the higher level entry point of Compose, designed to provide components that match
        // those described at www.material.io.
        const val material = "androidx.compose.material:material:${Versions.AndroidX.compose}"

        // Tooling support (Previews, etc.)
        const val uiTooling = "androidx.compose.ui:ui-tooling:${Versions.AndroidX.compose}"

        // Material design icons
        const val materialIconsCore =
            "androidx.compose.material:material-icons-core:${Versions.AndroidX.compose}"
        const val materialIconsExtended =
            "androidx.compose.material:material-icons-extended:${Versions.AndroidX.compose}"

        // Integration with observables
        const val runtimeLivedata =
            "androidx.compose.runtime:runtime-livedata:${Versions.AndroidX.compose}"

        // Navigation
        const val navigation =
            "androidx.navigation:navigation-compose:${Versions.AndroidX.composeNavigation}"
    }

    // Important: Always import the -ktx artifact when available.
    // The -ktx artifact depends transitively on the non-ktx (pure Java) version.
    object AndroidX {
        const val activityCompose =
            "androidx.activity:activity-compose:${Versions.AndroidX.activity}"
        const val activityKtx = "androidx.activity:activity-ktx:${Versions.AndroidX.activity}"
        const val core = "androidx.core:core-ktx:${Versions.AndroidX.core}"
        const val lifecycleViewModelCompose =
            "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.AndroidX.lifecycle}"
        const val lifecycleViewModelKtx =
            "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.AndroidX.lifecycle}"
        const val preferencesKtx =
            "androidx.preference:preference-ktx:${Versions.AndroidX.preferences}"
        const val exifinterface =
            "androidx.exifinterface:exifinterface:${Versions.AndroidX.exifinterface}"
    }

    object CameraX {
        const val core = "androidx.camera:camera-core:${Versions.AndroidX.camera}"
        const val camera = "androidx.camera:camera-camera2:${Versions.AndroidX.camera}"
        const val lifecycle = "androidx.camera:camera-lifecycle:${Versions.AndroidX.camera}"
        const val video = "androidx.camera:camera-video:${Versions.AndroidX.camera}"
        const val view = "androidx.camera:camera-view:${Versions.AndroidX.camera}"
        const val extensions = "androidx.camera:camera-extensions:${Versions.AndroidX.camera}"
    }

    // Accompanist is a group of libraries that aim to supplement Jetpack Compose with features that
    // are commonly required by developers but not yet available.
    // https://google.github.io/accompanist/
    object Accompanist {
        const val coil = "com.google.accompanist:accompanist-coil:${Versions.accompanist}"
        const val pager = "com.google.accompanist:accompanist-pager:${Versions.accompanist}"
        const val uiController =
            "com.google.accompanist:accompanist-systemuicontroller:${Versions.accompanist}"
        const val permissions =
            "com.google.accompanist:accompanist-permissions:${Versions.accompanist}"
    }

    // Third party
    const val jtsCore = "org.locationtech.jts:jts-core:${Versions.jtsCore}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val couchbaseLite =
        "com.couchbase.lite:couchbase-lite-android-ee-ktx:${Versions.couchbaseLite}"
    const val osmdroid = "org.osmdroid:osmdroid-android:${Versions.osmdroid}"
    const val arcore = "com.google.ar:core:${Versions.arcore}"
    const val exoplayer = "com.google.android.exoplayer:exoplayer:${Versions.exoplayer}"

    object Test {
        const val junit = "junit:junit:${Versions.junit}"
    }
}
