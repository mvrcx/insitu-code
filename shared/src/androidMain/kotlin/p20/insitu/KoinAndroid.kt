package p20.insitu

import com.couchbase.lite.Database
import org.koin.core.module.Module
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module
import p20.insitu.db.documentation.provideDatabase

actual val platformModule: Module = module {

    single<Database?> {
        provideDatabase(get(), get(parameters = { parametersOf("Couchbase") }))
    }
}