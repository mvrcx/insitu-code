package p20.insitu.android

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import org.koin.dsl.module
import p20.insitu.AppInfo
import p20.insitu.initKoin

/**
 * The main android application
 *
 * Koin initalization start point for android platform.
 *
 * @constructor Creates MainApplication
 */
class MainApplication : Application() {

    /**
     * Inits Koin modules when lifecycle state "onCreate" of the android application is reached.
     */
    override fun onCreate() {
        super.onCreate()
        initKoin(
            listOf(
                module {
                    // inject Android context
                    single<Context> { this@MainApplication }
                    // inject current Application
                    single<Application> { this@MainApplication }
                    single<AppInfo> { AndroidAppInfo }
                    single {
                        { Log.i("Startup", "Hello from Android/Kotlin!") }
                    }
                }
            )
        )
    }
}

object AndroidAppInfo : AppInfo {
    override val appId: String = BuildConfig.APPLICATION_ID
}