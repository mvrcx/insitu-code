package p20.insitu.model.components.spatial.geometry2d.prefabs


interface ChairPrefab : Prefab2D{

    fun getSeat(): Prefab2D?
    fun getBackrest(): Prefab2D?
    fun getArmrests(): List<Prefab2D>
    fun getChairLegs(): List<Prefab2D>

}