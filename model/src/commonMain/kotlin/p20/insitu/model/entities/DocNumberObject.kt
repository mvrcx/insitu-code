package p20.insitu.model.entities

import p20.insitu.model.components.DocNumber

/**
 * Interface for hierarchical objects that can have a [DocNumber], i.e. documentation number, assigned.
 */
interface DocNumberObject : HierarchicalObject  {

    /**
     * The documentation number.
     */
    var docNumber: DocNumber?

}

fun List<DocNumberObject>.sortByDocNumber(): List<DocNumberObject>{
    return this.sortedBy {
        it.docNumber?.docNumberString?.filter { docNbrStr -> docNbrStr.isDigit() }?.toInt()
    }
}