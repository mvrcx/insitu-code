package p20.insitu.db.catalogs

import org.koin.core.component.KoinComponent

actual class CatalogCsvImporter : KoinComponent {

    actual suspend fun updateDatabase(onProgressChanged: (intermediate: Boolean, progress: Float) -> Unit) {
        TODO("Not yet implemented")
    }

}