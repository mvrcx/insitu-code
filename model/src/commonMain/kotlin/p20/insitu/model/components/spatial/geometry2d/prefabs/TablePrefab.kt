package p20.insitu.model.components.spatial.geometry2d.prefabs

interface TablePrefab : Prefab2D {

    fun getTableTop(): Prefab2D?

    fun getTableLegs(): List<Prefab2D>

}