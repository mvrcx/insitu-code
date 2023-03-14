package p20.insitu.db.catalogs

import org.koin.core.component.KoinComponent

expect class CatalogCsvImporter : KoinComponent {

    suspend fun initDatabase(onProgressChanged: (inProgress: Boolean, catalogCount: Int, progress: Float) -> Unit)

    suspend fun updateDatabase(onProgressChanged: (inProgress: Boolean, catalogCount: Int, progress: Float) -> Unit)

}