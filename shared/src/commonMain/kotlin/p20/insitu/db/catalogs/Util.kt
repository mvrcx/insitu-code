package p20.insitu.db.catalogs

import p20.insitu.model.components.*
import p20.insitu.model.xpolizei.schema.Code

fun Catalog.getRealmObject(): RCatalog {
    return RCatalog().also {
        it.key = this.key
        it.name = this.name
        it.version = this.version
    }
}

fun CatalogCode.getRealmObject(): RCatalogCode {
    return when (this) {
        is CatalogCodeWithAddition<*> -> {
            RCatalogCode().also {
                it.code = this.code
                it.designation = this.name
                it.additionalValue = this.additionalValue
                it.catalogKey = this.catalog.key
                it.catalogName = this.catalog.name
                it.catalogVersion = this.catalog.version
            }
        }
        is CatalogCodeNotComplete<*> -> {
            RCatalogCode().also {
                it.code = this.code
                it.designation = this.name
                it.unlistedValue = this.unlistedValue
                it.catalogKey = this.catalog.key
                it.catalogName = this.catalog.name
                it.catalogVersion = this.catalog.version
            }
        }
        is CatalogCodeWithAdditionNotComplete<*> -> {
            RCatalogCode().also {
                it.code = this.code
                it.designation = this.name
                it.additionalValue = this.additionalValue
                it.unlistedValue = this.unlistedValue
                it.catalogKey = this.catalog.key
                it.catalogName = this.catalog.name
                it.catalogVersion = this.catalog.version
            }
        }
        else -> {
            // is CatalogCodeFixed<*>
            RCatalogCode().also {
                it.code = this.code
                it.designation = this.name
                it.catalogKey = this.catalog.key
                it.catalogName = this.catalog.name
                it.catalogVersion = this.catalog.version
            }
        }
    }
}

fun RCatalogCode.toCatalogCode(): CatalogCode {
    val additionalValue = !this.additionalValue.isNullOrEmpty()
    val unlistedValue = !this.unlistedValue.isNullOrEmpty()
    return when {
        additionalValue && unlistedValue -> {
            this.toCatalogCodeWithAdditionNotComplete<Code>()
        }
        additionalValue -> {
            this.toCatalogCodeWithAddition<Code>()
        }
        unlistedValue -> {
            this.toCatalogCodeNotComplete<Code>()
        }
        else -> {
            this.toCatalogCodeFixed<Code>()
        }
    }
}

fun List<RCatalogCode>.toCatalogCodes(): List<CatalogCode> {
    return this.map { it.toCatalogCode() }
}

fun <C : Code> List<RCatalogCode>.toCatalogCodesFixed(): List<CatalogCodeFixed<C>> {
    return this.map { it.toCatalogCodeFixed() }
}

fun <C > List<RCatalogCode>.toCatalogCodesNotComplete(): List<CatalogCodeNotComplete<C>> {
    return this.map { it.toCatalogCodeNotComplete() }
}

fun <C> List<RCatalogCode>.toCatalogCodesWithAddition(): List<CatalogCodeWithAddition<C>> {
    return this.map { it.toCatalogCodeWithAddition() }
}

fun <C> List<RCatalogCode>.toCatalogCodesWithAdditionNotComplete(): List<CatalogCodeWithAdditionNotComplete<C>> {
    return this.map { it.toCatalogCodeWithAdditionNotComplete() }
}

fun <C : Code> RCatalogCode.toCatalogCodeFixed(): CatalogCodeFixed<C> {
    return CatalogCodeFixed(
        code = this.code ?: "",
        name = this.designation ?: "",
        catalog = Catalog(
            key = this.catalogKey ?: "",
            name = this.catalogName,
            version = this.catalogVersion
        )
    )
}

fun <C> RCatalogCode.toCatalogCodeWithAddition(): CatalogCodeWithAddition<C> {
    return CatalogCodeWithAddition(
        code = this.code,
        name = this.designation,
        additionalValue = this.additionalValue,
        catalog = Catalog(
            key = this.catalogKey ?: "",
            name = this.catalogName,
            version = this.catalogVersion
        )
    )
}

fun <C> RCatalogCode.toCatalogCodeNotComplete(): CatalogCodeNotComplete<C> {
    return CatalogCodeNotComplete(
        code = this.code,
        name = this.designation,
        unlistedValue = this.unlistedValue,
        catalog = Catalog(
            key = this.catalogKey ?: "",
            name = this.catalogName,
            version = this.catalogVersion
        )
    )
}

fun <C> RCatalogCode.toCatalogCodeWithAdditionNotComplete(): CatalogCodeWithAdditionNotComplete<C> {
    return CatalogCodeWithAdditionNotComplete(
        code = this.code,
        name = this.designation,
        additionalValue = this.additionalValue,
        unlistedValue = this.unlistedValue,
        catalog = Catalog(
            key = this.catalogKey ?: "",
            name = this.catalogName,
            version = this.catalogVersion
        )
    )
}
