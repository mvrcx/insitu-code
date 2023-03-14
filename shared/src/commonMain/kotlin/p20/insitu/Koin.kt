package p20.insitu

import co.touchlab.kermit.Logger
import co.touchlab.kermit.StaticConfig
import co.touchlab.kermit.platformLogWriter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.datetime.Clock
import org.koin.core.KoinApplication
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.core.parameter.parametersOf
import org.koin.core.scope.Scope
import org.koin.dsl.module
import p20.insitu.com.comModules
import p20.insitu.db.documentation.DocuDataApi
import p20.insitu.db.settings.SettingsRepo
import p20.insitu.resources.FileHandler
import p20.insitu.db.documentation.DocuDataRepo
import p20.insitu.stateHandler.DocuHandler
import p20.insitu.stateHandler.SessionHandler
import p20.insitu.stateHandler.UiStateHandler
import p20.insitu.viewmodels.viewModelsModule

fun initKoin(appModules: List<Module>): KoinApplication {
    val allModules = appModules.toMutableList().also {
        it.add(platformModule)
        it.addAll(comModules)
        it.add(coreModule)
        it.add(viewModelsModule)
    }
    val koinApplication = startKoin {
        modules(
            allModules
        )
    }

    // Dummy initialization logic, making use of appModule declarations for demonstration purposes.
    val koin = koinApplication.koin
    // doOnStartup is a lambda which is implemented in Swift on iOS side
    val doOnStartup = koin.get<() -> Unit>()
    doOnStartup.invoke()

    val kermit = koin.get<Logger> { parametersOf(null) }
    // AppInfo is a Kotlin interface with separate Android and iOS implementations
    val appInfo = koin.get<AppInfo>()
    kermit.v { "App Id ${appInfo.appId}" }

    return koinApplication
}

private val coreModule = module {

    factory { CoroutineScope(Dispatchers.Default) }

    single(createdAtStart = true) {
        DocuDataRepo(
            log = getWith(DocuDataRepo::class.simpleName),
            docuDataApi = get()
        )
    }

    single {
        UiStateHandler(log = getWith(UiStateHandler::class.simpleName))
    }

    single {
        FileHandler()
    }

    single {
        DocuDataApi()
    }

    single {
        DocuHandler(
            log = getWith(DocuHandler::class.simpleName),
            coroutineScope = get(),
            docuDataRepo = get()
        )
    }

    single {
        SessionHandler(
            log = getWith(SessionHandler::class.simpleName),
            coroutineScope = get(),
            authService = get(),
            appDataRepo = get(),
            docuHandler = get()
        )
    }

    single<Clock> {
        Clock.System
    }

    single {
        SettingsRepo(
            log = getWith(SettingsRepo::class.simpleName),
            coroutineScope = get()
        )
    }

    // platformLogWriter() is a relatively simple config option, useful for local debugging. For production
    // uses you *may* want to have a more robust configuration from the native platform. In KaMP Kit,
    // that would likely go into platformModule expect/actual.
    // See https://github.com/touchlab/Kermit
    val baseLogger =
        Logger(config = StaticConfig(logWriterList = listOf(platformLogWriter())), "INSITU")
    factory { (tag: String?) -> if (tag != null) baseLogger.withTag(tag) else baseLogger }
}

internal inline fun <reified T> Scope.getWith(vararg params: Any?): T {
    return get(parameters = { parametersOf(*params) })
}

// Simple function to clean up the syntax a bit
fun KoinComponent.injectLogger(tag: String): Lazy<Logger> = inject { parametersOf(tag) }

expect val platformModule: Module