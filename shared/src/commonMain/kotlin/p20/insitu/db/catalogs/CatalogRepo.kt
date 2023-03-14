package p20.insitu.db.catalogs

import co.touchlab.kermit.Logger
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.ext.query
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.flow
import org.koin.core.component.KoinComponent
import p20.insitu.model.components.*
import p20.insitu.model.util.CatalogInfo
import p20.insitu.model.xpolizei.schema.*

class CatalogRepo(
    private val log: Logger,
    private val coroutineScope: CoroutineScope
) : KoinComponent {

    //region Config
    private val config = RealmConfiguration.Builder(
        setOf(
            RCatalog::class,
            RCatalogCode::class
        )
    ).build() //.encryptionKey(getNewRealmKey()).build()

    private val catalogRealm = Realm.open(config)
    //endregion

    //region Delete
    suspend fun deleteAll() {
        catalogRealm.write {
            delete(this.query<RCatalog>().find())
            delete(this.query<RCatalogCode>().find())
        }
    }
    //endregion

    //region Upsert
    suspend fun upsertCatalog(catalog: Catalog) {
        catalogRealm.write {
            val existingCatalog = this.query<RCatalog>(
                query = "key == $0",
                args = arrayOf(catalog.key)
            ).find().firstOrNull()
            if (existingCatalog != null) {
                findLatest(existingCatalog)?.let {
                    it.name = catalog.name
                    it.version = catalog.version
                }
            } else {
                copyToRealm(catalog.getRealmObject())
            }
        }
    }

    suspend fun upsertCatalogValues(catalogValues: List<CatalogCode>) {
        catalogRealm.write {
            catalogValues.forEach { catalogCode ->
                val existingCatalogValue = this.query<RCatalogCode>(
                    query = "code == $0",
                    catalogCode.code
                ).find().firstOrNull()
                if (existingCatalogValue != null) {
                    findLatest(existingCatalogValue)?.let {
                        it.designation = catalogCode.name
                        it.additionalValue =
                            (catalogCode as? CatalogCodeWithAddition<*>)?.additionalValue
                                ?: (catalogCode as? CatalogCodeWithAdditionNotComplete<*>)?.additionalValue
                        it.unlistedValue =
                            (catalogCode as? CatalogCodeNotComplete<*>)?.unlistedValue
                                ?: (catalogCode as? CatalogCodeWithAdditionNotComplete<*>)?.unlistedValue
                        it.catalogKey = catalogCode.catalog.key
                        it.catalogName = catalogCode.catalog.name
                        it.catalogVersion = catalogCode.catalog.version
                    }
                } else {
                    copyToRealm(catalogCode.getRealmObject())
                }
            }
        }
    }

    suspend fun upsertCatalogValue(catalogCode: CatalogCode) {
        catalogRealm.write {
            val existingCatalogValue = this.query<RCatalogCode>(
                query = "code == $0",
                catalogCode.code
            ).find().firstOrNull()
            if (existingCatalogValue != null) {
                findLatest(existingCatalogValue)?.let {
                    it.designation = catalogCode.name
                    it.additionalValue =
                        (catalogCode as? CatalogCodeWithAddition<*>)?.additionalValue
                            ?: (catalogCode as? CatalogCodeWithAdditionNotComplete<*>)?.additionalValue
                    it.unlistedValue =
                        (catalogCode as? CatalogCodeNotComplete<*>)?.unlistedValue
                            ?: (catalogCode as? CatalogCodeWithAdditionNotComplete<*>)?.unlistedValue
                    it.catalogKey = catalogCode.catalog.key
                    it.catalogName = catalogCode.catalog.name
                    it.catalogVersion = catalogCode.catalog.version
                }
            } else {
                copyToRealm(catalogCode.getRealmObject())
            }
        }
    }
    //endregion

    //region Fetch
    suspend fun getCatalog(catalog: CatalogInfo): RCatalog? =
        withContext(coroutineScope.coroutineContext) {
            return@withContext catalogRealm.query<RCatalog>(
                query = "key == $0",
                catalog.key
            ).find().firstOrNull()
        }

    suspend fun getCatalogs(): List<RCatalog> =
        withContext(coroutineScope.coroutineContext) {
            return@withContext catalogRealm.query<RCatalog>().find()
        }

    suspend fun getCatalogValues(key: String): List<CatalogCode> =
        withContext(coroutineScope.coroutineContext) {
            return@withContext catalogRealm.query<RCatalogCode>(
                query = "catalogKey == $0",
                key
            ).find().toCatalogCodes()
        }

    suspend fun getCatalogValues(catalog: CatalogInfo): List<CatalogCode> =
        withContext(coroutineScope.coroutineContext) {
            return@withContext catalogRealm.query<RCatalogCode>(
                query = "catalogKey == $0",
                catalog.key
            ).find().toCatalogCodes()
        }

    suspend fun <C : Code> getCatalogFixedValues(catalog: CatalogInfo): List<CatalogCodeFixed<C>> =
        withContext(coroutineScope.coroutineContext) {
            return@withContext catalogRealm.query<RCatalogCode>(
                query = "catalogKey == $0",
                catalog.key
            ).find().toCatalogCodesFixed()
        }

    suspend fun <C> getCatalogNotCompleteValues(catalog: CatalogInfo): List<CatalogCodeNotComplete<C>> =
        withContext(coroutineScope.coroutineContext) {
            return@withContext catalogRealm.query<RCatalogCode>(
                query = "catalogKey == $0",
                catalog.key
            ).find().toCatalogCodesNotComplete()
        }

    suspend fun <C> getCatalogWithAdditionValues(catalog: CatalogInfo): List<CatalogCodeWithAddition<C>> =
        withContext(coroutineScope.coroutineContext) {
            return@withContext catalogRealm.query<RCatalogCode>(
                query = "catalogKey == $0",
                catalog.key
            ).find().toCatalogCodesWithAddition()
        }

    suspend fun <C> getCatalogWithAdditionNotCompleteValues(catalog: CatalogInfo): List<CatalogCodeWithAdditionNotComplete<C>> =
        withContext(coroutineScope.coroutineContext) {
            return@withContext catalogRealm.query<RCatalogCode>(
                query = "catalogKey == $0",
                catalog.key
            ).find().toCatalogCodesWithAdditionNotComplete()
        }


    suspend fun getCatalogValues(catalogues: List<CatalogInfo>): Map<CatalogInfo, List<CatalogCode>> =
        withContext(coroutineScope.coroutineContext) {
            val result = mutableMapOf<CatalogInfo, List<CatalogCode>>()
            val tasks = mutableMapOf<CatalogInfo, Deferred<List<CatalogCode>>>()
            catalogues.forEach {
                tasks[it] = async { getCatalogValues(it) }
            }
            tasks.forEach {
                result[it.key] = it.value.await()
            }
            return@withContext result
        }
    //endregion

    //region Catalog data flows
    val locationType = flow {
        emit(getCatalogNotCompleteValues<KatalogCode115>(CatalogInfo.CATALOG_115_ART_DER_OERTLICHKEIT))
    }

    val typeOfPersonalDetails = flow {
        emit(getCatalogFixedValues<KatalogCode117>(CatalogInfo.CATALOG_117_ART_DER_PERSONALIE))
    }

    val typeOfObject = flow {
        emit(getCatalogNotCompleteValues<KatalogCode119_NichtAbgeschlossen>(CatalogInfo.CATALOG_119_ART_DER_SONSTIGEN_SACHE))
    }

    val typeOfPhysicalTrace = flow {
        emit(getCatalogFixedValues<KatalogCode120>(CatalogInfo.CATALOG_120_ART_DER_MATERIELLEN_SPUR))
    }

    val typeOfCrime = flow {
        emit(getCatalogFixedValues<KatalogCode121>(CatalogInfo.CATALOG_121_ART_DES_DELIKTS))
    }

    val typeOfProcess = flow {
        emit(getCatalogFixedValues<KatalogCode123>(CatalogInfo.CATALOG_123_ART_DES_VORGANGS))
    }

    val country = flow {
        emit(getCatalogNotCompleteValues<KatalogCode208_NichtAbgeschlossen>(CatalogInfo.CATALOG_208_STAAT))
    }

    val yesNo = flow {
        emit(getCatalogFixedValues<KatalogCode217>(CatalogInfo.CATALOG_217_JA_NEIN))
    }

    val processingStatus = flow {
        emit(getCatalogFixedValues<KatalogCode221>(CatalogInfo.CATALOG_221_BEARBEITUNGSSTAND))
    }

    val priority = flow {
        emit(getCatalogFixedValues<KatalogCode235>(CatalogInfo.CATALOG_235_PRIORITAET))
    }

    val modusOperandi = flow {
        emit(getCatalogFixedValues<KatalogCode245>(CatalogInfo.CATALOG_245_MODUS_OPERANDI))
    }

    val ethnicity = flow {
        emit(getCatalogNotCompleteValues<KatalogCode251_NichtAbgeschlossen>(CatalogInfo.CATALOG_251_VOLKSZUGEHOERIGKEIT))
    }

    val title = flow {
        emit(getCatalogNotCompleteValues<KatalogCode252_MitZusatz_NichtAbgeschlossen>(CatalogInfo.CATALOG_252_TITEL))
    }

    val maritalStatus = flow {
        emit(getCatalogFixedValues<KatalogCode254>(CatalogInfo.CATALOG_254_FAMILIENSTAND))
    }

    val sex = flow {
        emit(getCatalogFixedValues<KatalogCode255>(CatalogInfo.CATALOG_255_GESCHLECHT))
    }

    val religion = flow {
        emit(getCatalogNotCompleteValues<KatalogCode257_NichtAbgeschlossen>(CatalogInfo.CATALOG_257_RELIGION))
    }

    val europeanCrimeCategories = flow {
        emit(getCatalogNotCompleteValues<KatalogCode272_NichtAbgeschlossen>(CatalogInfo.CATALOG_272_EUROPAEISCHE_STRAFTATENKATEGORIE))
    }

    val countryOrArea = flow {
        emit(getCatalogNotCompleteValues<KatalogCode285_NichtAbgeschlossen>(CatalogInfo.CATALOG_285_LAND_GEBIET))
    }

    val crimeCharacteristics = flow {
        emit(getCatalogNotCompleteValues<KatalogCode304_NichtAbgeschlossen>(CatalogInfo.CATALOG_304_TATBESTANDSMERKMAL_EINER_STRAFTAT))
    }

    val victimOffenderType = flow {
        emit(getCatalogWithAdditionValues<KatalogCode318_MitZusatz>(CatalogInfo.CATALOG_318_OPFERTYPUS_TAETERTYPUS))
    }

    val federalState = flow {
        emit(getCatalogFixedValues<KatalogCode321>(CatalogInfo.CATALOG_321_BUNDESLAND))
    }

    val personalIDType = flow {
        emit(getCatalogNotCompleteValues<KatalogCode322_NichtAbgeschlossen>(CatalogInfo.CATALOG_322_ART_DER_PERSONENIDENTIFIKATIONSNUMMER))
    }

    val qualityOfTrace = flow {
        emit(getCatalogFixedValues<KatalogCode327>(CatalogInfo.CATALOG_327_VERWERTBARKEIT))
    }

    val category = flow {
        emit(getCatalogFixedValues<KatalogCode330>(CatalogInfo.CATALOG_330_KATEGORISIERUNG_DES_VORGANGS))
    }

    val storageStatus = flow {
        emit(getCatalogFixedValues<KatalogCode331>(CatalogInfo.CATALOG_331_LAGERSTATUS_DES_ASSERVATS))
    }

    val unDangerousGoodsNumber = flow {
        emit(getCatalogFixedValues<KatalogCode349>(CatalogInfo.CATALOG_349_GEFAHRGUT_UN_NUMMER))
    }

    val purposeOfSecuring = flow {
        emit(getCatalogFixedValues<KatalogCode369>(CatalogInfo.CATALOG_369_ZWECK_DER_ASSERVIERUNG))
    }

    val legalAsset = flow {
        emit(getCatalogFixedValues<KatalogCode370>(CatalogInfo.CATALOG_370_RECHTSGUT))
    }

    val municipalityCode = flow {
        emit(getCatalogFixedValues<KatalogCode370>(CatalogInfo.CATALOG_371_GEMEINDESCHLUESSEL))
    }

    val dangerousGoodsNumber = flow {
        emit(getCatalogFixedValues<KatalogCode395>(CatalogInfo.CATALOG_395_NUMMER_ZUR_KENNZEICHNUNG_DER_GEFAHR))
    }

    val securingMethod = flow {
        emit(getCatalogNotCompleteValues<KatalogCode405_NichtAbgeschlossen>(CatalogInfo.CATALOG_405_SICHERUNGSART))
    }
    //endregion
}