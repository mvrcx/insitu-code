package p20.insitu.db.catalogs

import android.content.Context
import co.touchlab.kermit.Logger
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.component.inject
import org.koin.core.parameter.parametersOf
import p20.insitu.model.components.Catalog
import p20.insitu.model.components.CatalogCode
import p20.insitu.model.components.CatalogCodeFixed
import p20.insitu.model.xpolizei.schema.Code
import p20.insitu.resources.FileHandler
import java.io.*

actual class CatalogCsvImporter : KoinComponent {

    private val log: Logger = get(parameters = { parametersOf("CatalogCsvImporter") })
    private val catalogRepo: CatalogRepo by inject()
    private val fileHandler: FileHandler = get()
    private val context: Context by inject()

    @OptIn(DelicateCoroutinesApi::class)
    private val globalCoroutineScope: CoroutineScope = GlobalScope

    fun numberOfAvailableCatalogs(): Int {
        // Count catalog file names from catalog_file_names.txt
        var totalNbrOfCatalogs = 0
        try {
            fileHandler.getBinaryFile("res/raw", "catalog_file_names.txt")?.let { data ->
                BufferedReader(
                    InputStreamReader(
                        ByteArrayInputStream(data)
                    )
                )
            }?.use { reader ->
                while (reader.readLine() != null) {
                    totalNbrOfCatalogs++
                }
            }
        } catch (e: FileNotFoundException) {
            log.e(e.localizedMessage ?: e.message ?: e.toString())
        } catch (e: IOException) {
            log.e(e.localizedMessage ?: e.message ?: e.toString())
        }

        return totalNbrOfCatalogs
    }

    suspend fun numberOfSuccessfullyImportedCatalogs():Int {
        // Read all catalog file names from catalog_file_names.txt
        val catalogFileNames = mutableListOf<String>()
        try {
            fileHandler.getBinaryFile("res/raw", "catalog_file_names.txt")?.let { data ->
                BufferedReader(
                    InputStreamReader(
                        ByteArrayInputStream(data)
                    )
                )
            }?.use { reader ->
                var line: String?
                while (reader.readLine().also { line = it } != null) {
                    line?.let {
                        catalogFileNames.add(it)
                    }
                }
            }
        } catch (e: FileNotFoundException) {
            log.e(e.localizedMessage ?: e.message ?: e.toString())
        } catch (e: IOException) {
            log.e(e.localizedMessage ?: e.message ?: e.toString())
        }

        var successfullyParsedCatalogs = 0
        val totalNbrOfCatalogs = catalogFileNames.size

        log.d("Parsing $totalNbrOfCatalogs local catalog files...")
        catalogFileNames.forEach { fileName ->
            var catalogKey: String? = null
            var catalogValues = 0
            try {
                fileHandler.getBinaryFile("res/raw", fileName)?.let { data ->
                    BufferedReader(
                        InputStreamReader(
                            ByteArrayInputStream(data)
                        )
                    )
                }?.use { reader ->
                    var lineNbr = 0
                    while (reader.ready()) {
                        val line = reader.readLine()
                        lineNbr++
                        // Read catalog meta data
                        if (lineNbr == 7) {
                            parseLine(line, colsToParse = 6).let { parsedLine ->
                                // Create catalog object
                                catalogKey = parsedLine[0].padStart(3, '0')
                            }
                        }
                        // Read catalog values
                        if (lineNbr >= 11) {
                            catalogValues++
                        }
                    }
                }
            } catch (e: FileNotFoundException) {
                log.e(e.localizedMessage ?: e.message ?: e.toString())
            } catch (e: IOException) {
                log.e(e.localizedMessage ?: e.message ?: e.toString())
            }

            // Check if number of catalog values in DB equals number of catalog values in file
            if(catalogRepo.getCatalogValues(catalogKey?:"").size == catalogValues){
                successfullyParsedCatalogs++
            }
        }

        return successfullyParsedCatalogs
    }

    actual suspend fun updateDatabase(onProgressChanged: (inProgress: Boolean, catalogCount: Int, progress: Float) -> Unit) {
        // Clear the database
        catalogRepo.deleteAll()
        log.d("Catalog database cleared")
        initDatabase(onProgressChanged)
    }

    actual suspend fun initDatabase(onProgressChanged: (inProgress: Boolean, catalogCount: Int, progress: Float) -> Unit) {

        if (catalogRepo.getCatalogs().isEmpty()) {
            onProgressChanged(true, 0, 0f)

            // Read all catalog file names from catalog_file_names.txt
            val catalogFileNames = mutableListOf<String>()
            try {
                fileHandler.getBinaryFile("res/raw", "catalog_file_names.txt")?.let { data ->
                    BufferedReader(
                        InputStreamReader(
                            ByteArrayInputStream(data)
                        )
                    )
                }?.use { reader ->
                    var line: String?
                    while (reader.readLine().also { line = it } != null) {
                        line?.let {
                            catalogFileNames.add(it)
                        }
                    }
                }
            } catch (e: FileNotFoundException) {
                log.e(e.localizedMessage ?: e.message ?: e.toString())
            } catch (e: IOException) {
                log.e(e.localizedMessage ?: e.message ?: e.toString())
            }

            var parsedCatalogs = 0
            val totalNbrOfCatalogs = catalogFileNames.size
            val channel = Channel<Triple<String, String, Int>>()
            // Loop through files, parse catalog data, write to database
            log.d("Parsing $totalNbrOfCatalogs local catalog files...")
            catalogFileNames.forEach { fileName ->
                globalCoroutineScope.launch {
                    try {
                        fileHandler.getBinaryFile("res/raw", fileName)?.let { data ->
                            BufferedReader(
                                InputStreamReader(
                                    ByteArrayInputStream(data)
                                )
                            )
                        }?.use { reader ->
                            var lineNbr = 0
                            var catalogKey: String? = null
                            var catalogName: String? = null
                            var catalogVersion: String? = null
                            val catalogValues = mutableListOf<CatalogCode>()
                            while (reader.ready()) {
                                val line = reader.readLine()
                                lineNbr++
                                // Read catalog meta data
                                if (lineNbr == 7) {
                                    parseLine(line, colsToParse = 6).let { parsedLine ->
                                        // Create catalog object
                                        catalogKey = parsedLine[0].padStart(3, '0')
                                        catalogName = parsedLine[1]
                                        catalogVersion = parsedLine[4]
                                        val catalog = Catalog(
                                            catalogKey ?: "",
                                            catalogName,
                                            catalogVersion
                                        )
                                        // Write to database≈
                                        catalogRepo.upsertCatalog(catalog)
                                    }
                                }
                                // Read catalog values
                                if (lineNbr >= 11) {
                                    parseLine(line, colsToParse = 2).let { parsedLine ->
                                        // Create catalog value object
                                        val code = parsedLine[0].padStart(3, '0')
                                        val designation = parsedLine[1]
                                        val catalogValue = CatalogCodeFixed<Code>(
                                            code,
                                            designation,
                                            Catalog(
                                                catalogKey ?: "",
                                                catalogName,
                                                catalogVersion
                                            )
                                        )
                                        catalogValues.add(catalogValue)
                                    }
                                }
                            }
                            // Write values to database
                            catalogRepo.upsertCatalogValues(catalogValues)
                            channel.send(
                                Triple(
                                    catalogKey ?: "",
                                    catalogName ?: "",
                                    catalogValues.size
                                )
                            )
                        }
                    } catch (e: FileNotFoundException) {
                        log.e(e.localizedMessage ?: e.message ?: e.toString())
                    } catch (e: IOException) {
                        log.e(e.localizedMessage ?: e.message ?: e.toString())
                    }
                }
            }

            // Track progress and update UI via callback
            repeat(totalNbrOfCatalogs) {
                val parsedCatalogInfo = channel.receive()
                log.d(
                    "Parsed catalog ${parsedCatalogInfo.first} '${parsedCatalogInfo.second}' --> " +
                            "${parsedCatalogInfo.third} catalog " +
                            "values have been written to the database"
                )
                parsedCatalogs++
                onProgressChanged(
                    parsedCatalogs != totalNbrOfCatalogs,
                    parsedCatalogs,
                    (parsedCatalogs / totalNbrOfCatalogs).toFloat()
                )
            }
        }
    }

    private fun parseLine(
        line: String,
        separator: Char = ';',
        colsToParse: Int? = null
    ): List<String> {
        val result = mutableListOf<String>()
        val builder = StringBuilder()
        var cols = 0

        for (ch in line) {
            when {
                (ch == '\n') || (ch == '\r') -> {}
                ch == separator -> {
                    result.add(builder.toString())
                    builder.clear()
                    cols++
                    if (cols == colsToParse) return result
                }
                else -> builder.append(ch)
            }
        }

        colsToParse?.let {
            if (cols + 1 == it) {
                result.add(builder.toString())
            }
        }

        return result
    }


}