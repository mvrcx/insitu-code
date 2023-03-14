package p20.insitu.model.xpolizei.interfaces

import p20.insitu.model.xpolizei.schema.AllgemeineBasisklasse

/**
 * Interface for the abstract XPolizei object [AllgemeineBasisklasse].
 * Declares a (sub-)set of relevant properties and maps them to its XPolizei counterparts.
 */
interface XpCommonBaseClass {

    /**
     * Maps to [AllgemeineBasisklasse.id].
     */
    val id: String

}