package p20.insitu.model.components.spatial.geometry2d.prefabs

import p20.insitu.model.components.spatial.geometry2d.shapes.IShape2D

interface Prefab2D : IShape2D {

    enum class ComparisonType {
        EQUALS, CONTAINS
    }

    var modelInfo: ModelInfo
    val parts: MutableList<Prefab2D>
    val pathModels: MutableList<PathModel>

    fun getPart(componentInfo: ComponentInfo): Prefab2D? {
        return getNestedParts().getByModelId(
            componentInfo.modelId,
            ComparisonType.EQUALS
        ).firstOrNull()
    }

    fun getNestedParts(): List<Prefab2D> {
        val allParts: MutableList<Prefab2D> = mutableListOf()
        for (part in parts) {
            allParts.add(part)
            allParts.addAll(part.getNestedParts())
        }
        return allParts
    }

    fun getNestedPathModels(): List<PathModel> {
        val allPathModels: MutableList<PathModel> = mutableListOf()
        for (part in parts) {
            allPathModels.addAll(part.pathModels)
            allPathModels.addAll(part.getNestedPathModels())
        }
        return allPathModels
    }

    fun List<PathModel>.getByName(
        name: String,
        comparisonType: ComparisonType = ComparisonType.EQUALS,
        ignoreCase: Boolean = false
    ): List<PathModel> {
        return when (comparisonType) {
            ComparisonType.EQUALS -> {
                this.filter { it.name.equals(name, ignoreCase) }
            }
            ComparisonType.CONTAINS -> {
                this.filter { it.name?.contains(name, ignoreCase) ?: false }
            }
        }
    }

    fun List<Prefab2D>.getByModelId(
        modelId: String,
        comparisonType: ComparisonType = ComparisonType.EQUALS,
        ignoreCase: Boolean = false
    ): List<Prefab2D> {
        return when (comparisonType) {
            ComparisonType.EQUALS -> {
                this.filter { it.modelInfo.modelId.equals(modelId, ignoreCase) }
            }
            ComparisonType.CONTAINS -> {
                this.filter { it.modelInfo.modelId?.contains(modelId, ignoreCase) ?: false }
            }
        }
    }

    fun List<Prefab2D>.getByShapeType(
        shapeType: String,
        comparisonType: ComparisonType = ComparisonType.EQUALS,
        ignoreCase: Boolean = false
    ): List<Prefab2D> {
        return when (comparisonType) {
            ComparisonType.EQUALS -> {
                this.filter { it.shapeType.equals(shapeType, ignoreCase) }
            }
            ComparisonType.CONTAINS -> {
                this.filter { it.shapeType.contains(shapeType, ignoreCase) }
            }
        }
    }
}