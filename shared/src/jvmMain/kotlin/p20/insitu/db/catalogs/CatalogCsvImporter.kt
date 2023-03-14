package p20.insitu.db.catalogs

import org.koin.core.component.KoinComponent

actual class CatalogCsvImporter : KoinComponent {

    actual suspend fun initDatabase(onProgressChanged: (inProgress: Boolean, catalogCount: Int, progress: Float) -> Unit){
        TODO("Not yet implemented")
    }

    actual suspend fun updateDatabase(onProgressChanged: (inProgress: Boolean, catalogCount: Int, progress: Float) -> Unit) {
        TODO("Not yet implemented")
    }

}