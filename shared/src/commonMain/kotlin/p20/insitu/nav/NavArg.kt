package p20.insitu.nav

enum class NavArg(val argName: String) {
    CATALOG_CATEGORY("catalogCategory"),
    CATALOG_SUB_CATEGORY("catalogSubCategory"),
    CATALOG_GROUP("catalogGroup"),
    CATALOG_CODE("catalogCode"),
    DESTINATION("destination"),
    ENTITY_ID("entityId"),
    IMAGE_INDEX("imageIndex"),
    INITIAL_TAB("initialTab"),
    MESSAGE("message"),
    SHOW_NESTED("showNested"),
}