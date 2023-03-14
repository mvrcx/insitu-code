package p20.insitu.model.components

import p20.insitu.model.xpolizei.schema.Code

interface CatalogCode {
    val code: String?
    val name: String?
    val catalog: Catalog

    override fun toString(): String
}

fun <C : Code> CatalogCode.toCatalogCodeFixed(): CatalogCodeFixed<C>? = try {
    @Suppress("UNCHECKED_CAST")
    this as CatalogCodeFixed<C>
} catch (e: ClassCastException) {
    null
}

fun <C> CatalogCode.toCatalogCodeWithAddition(): CatalogCodeWithAddition<C>? = try {
    @Suppress("UNCHECKED_CAST")
    this as CatalogCodeWithAddition<C>
} catch (e: ClassCastException) {
    null
}

fun <C> CatalogCode.toCatalogCodeNotComplete(): CatalogCodeNotComplete<C>? = try {
    @Suppress("UNCHECKED_CAST")
    this as CatalogCodeNotComplete<C>
} catch (e: ClassCastException) {
    null
}

fun <C> CatalogCode.toCatalogCodeWithAdditionNotComplete(): CatalogCodeWithAdditionNotComplete<C>? =
    try {
        @Suppress("UNCHECKED_CAST")
        this as CatalogCodeWithAdditionNotComplete<C>
    } catch (e: ClassCastException) {
        null
    }